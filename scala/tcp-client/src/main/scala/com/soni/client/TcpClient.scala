package com.soni.client

import java.net.InetSocketAddress

import akka.actor.{Actor, ActorRef, Props}
import akka.io.{IO, Tcp}
import akka.util.ByteString

object TcpClient {
  def props(remote: InetSocketAddress, listener: ActorRef) =
    Props(classOf[TcpClient], remote, listener)
}

class TcpClient(remote: InetSocketAddress, var listener: ActorRef) extends Actor {

  import Tcp._
  import context.system

  if (listener == null) listener = Tcp.get(context.system).manager

  IO(Tcp) ! Connect(remote)

  def receive = {
    case CommandFailed(_: Connect) =>
      listener ! "connect failed"
      context stop self

    case c @ Connected(remote, local) =>
      listener ! c
      val connection = sender()
      connection ! Register(self)
      context become {
        case data: ByteString =>
          connection ! Write(data)
        case CommandFailed(w: Write) =>
          // O/S buffer was full
          listener ! "write failed"
        case Received(data) =>
          println(s"Data received - ${data.utf8String}")
          listener ! data
        case "close" =>
          connection ! Close
        case _: ConnectionClosed =>
          listener ! "connection closed"
          context stop self
      }
  }
}
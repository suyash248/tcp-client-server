package com.soni.handler

import akka.actor.Actor
import akka.io.Tcp
import akka.util.ByteString

class SimplisticHandler extends Actor {
  import Tcp._
  def receive = {
    case Received(data) =>
      println(s"Data received - ${data.utf8String}")
      sender() ! Write(ByteString("SERVER_RES: ").concat(data))
    case PeerClosed     => context stop self
  }
}
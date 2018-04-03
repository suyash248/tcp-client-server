#!/usr/bin/env node
'use strict';

const net = require('net');

const PORT = 5000;
const ADDRESS = '0.0.0.0';

let server = net.createServer(onClientConnected);
server.listen(PORT, ADDRESS);

console.log(`Server started at: ${ADDRESS}:${PORT}`);

function onClientConnected(socket) {
  let clientName = `${socket.remoteAddress}:${socket.remotePort}`;
  console.log(`${clientName} connected.`);

  socket.on('data', (data) => { 
    let m = data.toString().replace(/[\n\r]*$/, '');
    console.log(`${clientName} said: ${m}`);
    socket.write(`We got your message (${m}). Thanks!\n`);
  });
  
  socket.on('end', () => {
    console.log(`${clientName} disconnected.`);
  });
}

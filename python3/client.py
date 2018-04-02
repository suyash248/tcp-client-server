import socket

host = 'localhost' # socket.gethostname()
port = 9900                   # The same port as used by the server
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((host, port))
print("Connected to {}:{}".format(host, port))
print("Enter messages to send to remote server, type 'stop' to exit.")

while True:
	raw_msg = input()
	if raw_msg and raw_msg.lower() == "stop": 
		print("Bye!")
		break
	d = str.encode(raw_msg)
	s.sendall(d)
	data = s.recv(1024)
	print('Received', repr(data))
s.close()

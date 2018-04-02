import socket

host = 'localhost'        # Symbolic name meaning all available interfaces
port = 9900     # Arbitrary non-privileged port

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((host, port))

s.listen(1)
print("Started server! listeing to {}:{}".format(host, port))
conn, addr = s.accept()
print('Connected by', addr)
while True:

    try:
        data = conn.recv(1024)
        if not data: break
        print ("Client Says: " + str(data))
        conn.sendall(str.encode("SERVER_RES: " + str(data)))
    except socket.error:
        print ("Error Occured.")
        break

conn.close()
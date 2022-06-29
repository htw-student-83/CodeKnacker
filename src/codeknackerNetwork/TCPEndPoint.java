package codeknackerNetwork;

import codeknacker.CodeKnackerStream;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEndPoint extends CodeKnackerStream {
    private static final int PORTNUMMER = 7070;
    static OutputStream os = null;
    static InputStream is = null;

    public static void main(String[] args) throws IOException {
        //Daten werden nun an den Server geschickt
        int sayOne = 1;
        String sayHello = "Hello";

        Socket socket = null;

        if (args.length == 0) {
            System.out.println("create a server socket.");
            TCPEndPoint serverEP = new TCPEndPoint();
            //Hier wird ein ServerSocket erst erzeugt und ist nicht mehr null
            socket = serverEP.createSocketBySever();

        } else {
            System.out.println("create a client socket.");
            TCPEndPoint serverEP = new TCPEndPoint();
            //Hier wird ein CLientSocket erst erzeugt und ist nicht mehr null
            socket = serverEP.createSocketByClient();
        }

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        //to send something
        dos.writeUTF(sayHello);
        //dos.writeInt(sayOne);
        System.out.println("1. verschickte Nachricht: " + sayHello);
        //System.out.println("2. verschickte Nachricht: " + sayOne);

        //to get something
        String data = dis.readUTF();
        //int dataInt = dis.readInt();
        System.out.println("1. Erhaltene Nachricht: " + data);
        //System.out.println("2. Erhaltene Nachricht: " + dataInt);

    }
    Socket createSocketBySever() throws IOException {
        ServerSocket server = new ServerSocket(PORTNUMMER);
        Socket socket = server.accept();
        System.out.println("server is created.");
        return socket;
    }


    Socket createSocketByClient() throws IOException {
        Socket clientSocket = new Socket("localhost", PORTNUMMER);
        System.out.println("client is with server connected.");
        return clientSocket;
    }
}


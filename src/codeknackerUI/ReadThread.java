package codeknackerUI;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadThread extends Thread {

    private final ReadThreadListener listener;
    private final InputStream is;

    ReadThread(InputStream is, ReadThreadListener listener) {
        this.is = is;
        this.listener = listener;
    }

    public void run() {
        DataInputStream dis = new DataInputStream(is);
        try {
            while(true) {
                String readString = dis.readUTF();
                String message = readString; // remove first bytes
                this.listener.recognizedMessage(message);
            }
        } catch (IOException e) {
            System.err.println("connection broken: " + e.getLocalizedMessage());
            this.listener.connectionClosed();
        }
    }

}

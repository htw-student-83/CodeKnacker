package codeknackerUI;

import codeknacker.CodeKnackerStream;
import codeknackerNetwork.TCPStream;
import codeknackerNetwork.TCPStreamCreatedListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DistributedCodeKnackerImpl extends CodeKnackerStream implements
        TCPStreamCreatedListener, ReadThreadListener {

    private InputStream is;
    private OutputStream os;



    @Override
    public void streamCreated(TCPStream channel) {
        try {
            synchronized(this) {
                this.is = channel.getInputStream();
                this.os = channel.getOutputStream();
            }
            // run ReadThread
            new ReadThread(this.is, this).start();
        } catch (IOException e) {
            System.err.println("fatal: " + e.getLocalizedMessage());
            System.exit(1);
        }
    }

    /*
    // guard method
    private boolean connected() {
        synchronized(this) {
            if (this.is != null && this.os != null) return true;

            // else
            System.out.println("no yet connected");
            return false;
        }
    }
     */

/*
    private void sendMessage(String message) {
        DataOutputStream das = new DataOutputStream(os);
        try {
            das.writeUTF(message);
        } catch (IOException e) {
            System.err.println("fatal: cannot send message: " + e.getLocalizedMessage());
        }
    }
 */

    @Override
    public void recognizedMessage(String message) throws IOException {
        CodeKnackerStream stream = new CodeKnackerStream();
        //DataInputStream dis = new DataInputStream(is);
        String name = stream.restoreGameResult();
        System.out.println("Historie wurde aufgerufen.");
        // tell other side
        sendMessage(name);
    }

    @Override
    public void connectionClosed() {

    }
}

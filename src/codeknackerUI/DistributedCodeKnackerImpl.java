package codeknackerUI;

import codeknackerNetwork.TCPStream;
import codeknackerNetwork.TCPStreamCreatedListener;

public class DistributedCodeKnackerImpl extends CodeKnackerUserCom implements TCPStreamCreatedListener, ReadThreadListener {

    @Override
    public void streamCreated(TCPStream channel) {

    }

    @Override
    public void recognizedMessage(byte message) {

    }

    @Override
    public void connectionClosed() {

    }
}

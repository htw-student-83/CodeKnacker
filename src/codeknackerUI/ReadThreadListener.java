package codeknackerUI;

import java.io.IOException;

public interface ReadThreadListener {
    /**
     * Tell listener message received
     * @param message
     */
    void recognizedMessage(String message) throws IOException;

    /**
     * Tell listener: connection closed
     */
    void connectionClosed();
}

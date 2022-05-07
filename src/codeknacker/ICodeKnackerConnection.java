package codeknacker;

import java.net.ConnectException;
import java.nio.channels.ClosedChannelException;

public interface ICodeKnackerConnection {

    /**
     * to connect with a second player for the game.
     * @throws ConnectException, if the connection is failed
     */
    void toConnect() throws ConnectException;


    /**
     * close a current connection between two computer.
     * @throws ClosedChannelException, if the connection can't stop
     */
    void closeCurrentConnection() throws ClosedChannelException;

}

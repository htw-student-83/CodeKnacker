package codeknacker;

import java.io.IOException;

public interface ICodeKnackerDrawFrame {

    /**
     * create the upper frame of the game.
     * @throws StatusException, if the connection between two computer is failed
     */
    String createTheUpperGameFrameStart() throws StatusException;


    /**
     * create the upper frame of the gaame, if a game round is finished.
     * @throws IOException
     */
    String createTheUpperGameFrameEnd() throws IOException;


    /**
     * create the down frame of the gaame, if a game round is finished.
     * @throws IOException
     */
    String createTheDownGameFrameEnd() throws IOException;


    /**
     * create the underline for a playername.
     * @throws StatusException
     */
    String createANUnderlineForPlayerName() throws StatusException;
}

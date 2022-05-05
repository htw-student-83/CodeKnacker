package codeknacker;

import java.io.IOException;

public interface CodeKnackerDrawFrame {

    /**
     * create the upper frame of the game.
     * @throws StatusException, if the connection between two computer is failed
     */
    void createTheUpperGameFrameStart() throws StatusException;


    /**
     * create the upper frame of the gaame, if a game round is finished.
     * @throws IOException
     */
    void createTheUpperGameFrameEnd() throws IOException;


    /**
     * create the down frame of the gaame, if a game round is finished.
     * @throws IOException
     */
    void createTheDownGameFrameEnd() throws IOException;


    /**
     * create the underline for a playername.
     * @throws StatusException
     */
    void createANUnderlineForPlayerName() throws StatusException;
}

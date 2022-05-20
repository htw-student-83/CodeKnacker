package codeknacker;

import java.io.IOException;

public interface ICodeKnackerResult {

    /**
     * to get the name' winner of the current game round
     * @return name of the winner
     * @throws
     */
    String theWinnerIs() throws IOException;


    /**
     * if there not a winner for the current game round
     * @return result of the game round
     * @throws IOException
     */
    String aRemis() throws IOException;
}

package codeknacker;

import java.io.IOException;

public interface CodeKnackerResult {

    /**
     * to get the name' winner of the current game round
     * @return name of the winner
     * @throws
     */
    String theWinnerIs() throws IOException;


    /**
     * if there not a winner for the ggame round the message "remi" is coming
     * @return result of the current game round
     * @throws
     */
    String aRemis() throws IOException;
}

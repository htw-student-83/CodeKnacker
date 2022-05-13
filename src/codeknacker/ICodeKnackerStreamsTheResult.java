package codeknacker;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ICodeKnackerStreamsTheResult {

    /**
     * to read the result of the last game round from a file
     * @throws IOException, if something was wrong
     */
    String restoreGameResult() throws IOException;

//Diese Methode
    /**
     * to save the current result of the game into a file
     * @param playerName, the winner of a game round
     * @throws FileNotFoundException, if the file is missing
     * @throws IOException, if something else is wrong
     */
    void saveGameResult(String playerName) throws FileNotFoundException, IOException;
}

package codeknacker;

import java.io.IOException;

public interface ICodeKnackerCheckUserNumber {
    /**
     * to check is the players' input number same as the current number what we just are looking for
     * @param number, the players' input number
     * @param playernumber the player, who is playing
     * @throws WrongStatusException, if a player input a number, but the other player is turn
     * @return true, if one of three numbers was found, otherwise false
     */
    boolean checkHintNumber(int number, int playernumber)throws WrongStatusException;

    /**
     * checks have we already a winner of a round
     * @return true, when a player with the most points exists otherwise false
     * @throws IOException
     */
    boolean won()throws IOException;
    //Polymorphie:
    //zwei verschiedene Methoden, die von außen gleichsind, werden von unterschiedlichen Objekten aufgerufen,
    //weil sie verschieden implementiert sind
}

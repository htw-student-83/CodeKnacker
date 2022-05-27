package codeknacker;

import codeknackerUI.NetworkException;

import java.io.IOException;

public interface ICodeKnackerCheckUserNumber {
    /**
     * to check is the players' input number same as the current number what we just are looking for
     * @param number, the players' input number
     * @param playernumber the player, who is playing
     * @throws WrongStatusException, if a player input a number, but the other player turns
     * @return true, if one of three numbers was found, otherwise false
     */
    boolean checkHintNumber(int number, int playernumber) throws Exception, NetworkException;

    /**
     * checks have we already a winner of a round
     * @return true, when a player with the most points exists otherwise false
     * @throws IOException
     */
    void endOfRound()throws IOException;
    //Polymorphie:
    //zwei verschiedene Methoden, die von außen gleichsind, werden von unterschiedlichen Objekten aufgerufen,
    //weil sie verschieden implementiert sind

    boolean checkHintNumberForTesting(int number, int playernumber)throws Exception, NetworkException;
}

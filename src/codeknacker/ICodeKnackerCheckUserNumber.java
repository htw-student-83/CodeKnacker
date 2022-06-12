package codeknacker;

import codeknackerUI.NetworkException;

import java.io.IOException;

public interface ICodeKnackerCheckUserNumber {
    /**
     * to check is the players' input number same as the current number what we just are looking for
     * @param number, the players' input number
     * @throws WrongStatusException, if a player input a number, but the other player turns
     * @return true, if one of three numbers was found, otherwise false
     */
    boolean checkHintNumber(int number) throws Exception, NetworkException;

    //Polymorphie:
    //zwei verschiedene Methoden, die von außen gleichsind, werden von unterschiedlichen Objekten aufgerufen,
    //weil sie verschieden implementiert sind

    /**
     *
     * @param number
     * @return
     * @throws Exception
     * @throws NetworkException
     */
    boolean checkHintNumberForTesting(int number)throws Exception, NetworkException;

    /**
     *
     * @param number, hintnumber
     * @param status, the current status of the game
     * @return true, if one search number is found, otherwise false
     * @throws Exception, if when something else if wrong
     */
    boolean checkHintNumberForTesting2(int number, CodeKnackerStatus status) throws Exception;


    /**
     * check, who is the winner of the current round
     * if both player have the same points, we have a remi
     * @return the result after a round
     */
    String won()throws IOException;
}

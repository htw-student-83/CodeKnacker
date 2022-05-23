package codeknackerUI;

import java.io.IOException;

public interface ICodeKnackerUserCommunication {
//Infertace for the  User-communication

    /**
     * to deliver a hint
     * @param playerName the name of the player
     * @param hint, the player's number
     * @throws IllegalArgumentException, if the player's input is invalid
     */
    void deliveryHint(String playerName, int hint) throws IllegalArgumentException;


    /**
     * users can give an attempt for one of the searching numbers
     * @throws IllegalArgumentException if, the user inputs something wrong
     */
    void yourHint() throws Exception, NetworkException;


    /**
     * ask the user for his next hint
     * @throws IOException, if, something else is wrong
     */
    boolean howIsYourNumberTip() throws Exception, NetworkException;


    /**
     * ask the user for a next start
     * @throws IOException, if, something else is wrong
     */
    void askForAsecondRound() throws Exception, NetworkException;

}

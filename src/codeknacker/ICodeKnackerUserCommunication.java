package codeknacker;

import java.io.IOException;

public interface ICodeKnackerUserCommunication {
//API for the communication with the player

    /**
     * to deliver a hint
     * @param playerName
     * @param hint
     * @return true, if the arguments are valid
     * @throws IllegalArgumentException
     */
    boolean deliveryHint(String playerName, int hint) throws IllegalArgumentException;


    /**
     * to get the message, that the input is smaller than the to find random number.
     * @param zahleneingabe, the inputNumber of a player
     * @throws IOException, if, something else is wrong
     */
    void inputNumberIsTooSmall(int zahleneingabe) throws IOException;


    /**
     * to get the message that the input is bigger than the to find random number.
     * @param zahleneingabe
     * @throws IOException, if, something else is wrong
     */
    void inputNumberIsTooBig(int zahleneingabe) throws IOException;


    /**
     * to get the message that the one of three random numbers was found.
     * @param zahleneingabe
     * @throws IOException, if, something else is wrong
     */
    void foundArandomNumber(int zahleneingabe) throws IOException;


    /**
     * users can give an attempt for one of the searching numbers
     * @throws IllegalArgumentException if, the user inputs something wrong
     */
    void yourHint()throws IllegalArgumentException;


    /**
     * a counter of the number inputs of an user
     * @return the number of attemps of a user
     * @throws IOException, if, something else is wrong
     */
    int numberOfInputs() throws IOException;


    /**
     * ask the user for his next hint
     * @throws IOException, if, something else is wrong
     */
    void howIsYourNumberTip() throws IOException;


    /**
     * ask the user for a next start
     * @throws IOException, if, something else is wrong
     */
    void askForAsecondRound() throws IOException;


    /**
     * using for testszenarien
     * @return the users hint as a Integer number
     * @throws IllegalArgumentException
     */
    String yourHint2() throws IllegalArgumentException;
}

package codeknacker;

import java.io.IOException;

public interface CodeKnackerUserCommunication {
//API for the communication with the player

    /**
     * to get the message, that the input is smaller than the to find random number.
     * @param zahleneingabe, the inputNumber of a player
     * @throws
     */
    void inputNumberIsTooSmall(int zahleneingabe) throws IOException;


    /**
     * to get the message that the input is bigger than the to find random number.
     * @param zahleneingabe
     * @throws
     */
    void inputNumberIsTooBig(int zahleneingabe) throws IOException;


    /**
     * to get the message that the one of three random numbers was found.
     * @param zahleneingabe
     * @throws
     */
    void foundArandomNumber(int zahleneingabe) throws IOException;


    /**
     * users can give an attempt for one of the searching numbers
     * @throws IllegalArgumentException if, the user inuts something wrong
     */
    void yourHint()throws IllegalArgumentException;


    /**
     * a counter of the number inputs of an user
     * @return the number of attemps of a user
     * @throws
     */
    int numberOfInputs() throws IOException;


    /**
     * ask the user for his next hint
     * @throws
     */
    void howIsYourNumberTip() throws IOException;


    /**
     * ask the user for a next start
     * @throws
     */
    void askForAsecondRound() throws IOException;

    String yourHint2() throws IllegalArgumentException;
}

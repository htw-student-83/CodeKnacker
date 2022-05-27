package codeknackerUI;

import java.io.IOException;

public interface ICodeKnackerUserCommunication {
//Infertace for the  User-communication

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

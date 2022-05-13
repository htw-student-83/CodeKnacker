package codeknacker;

import codeknackerUI.ICodeKnackerUserCommunication;

import java.io.IOException;
import java.util.Scanner;

public class CodeKnackerUserCom implements ICodeKnackerUserCommunication {
    @Override
    public void deliveryHint(String playerName, int hint) throws IllegalArgumentException {

    }

    @Override
    public void inputNumberIsTooSmall(int zahleneingabe) throws IOException {
        CodeKnackerRandomNumber codeArra = new CodeKnackerRandomNumber();
        int firstNumber = codeArra.getFinalElement();
        if(zahleneingabe<firstNumber){
            System.out.println("Unfornately, your input is too small.");
        }
    }

    @Override
    public void inputNumberIsTooBig(int zahleneingabe) throws IOException {
        CodeKnackerRandomNumber codeArra = new CodeKnackerRandomNumber();
        int firstNumber = codeArra.getFinalElement();
        if(zahleneingabe>firstNumber){
            System.out.println("Unfornately, your input is too big.");
        }
    }

    @Override
    public void foundArandomNumber(int zahleneingabe) throws IOException {

    }

    @Override
    public void yourHint() throws IllegalArgumentException {

    }

    public String yourHint2() throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public int numberOfInputs() throws IOException {
        return 0;
    }

    @Override
    public void howIsYourNumberTip() throws IOException {
        if(numberOfInputs()<=2) {
            System.out.println("How is your next number?");
        }
    }

    @Override
    public void askForAsecondRound() throws IOException {

    }
}

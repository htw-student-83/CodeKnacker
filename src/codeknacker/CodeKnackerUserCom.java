package codeknacker;

import java.io.IOException;
import java.util.Scanner;

public class CodeKnackerUserCom implements ICodeKnackerUserCommunication {
    @Override
    public boolean deliveryHint(String playerName, int hint) throws IllegalArgumentException {
        return false;
    }

    @Override
    public void inputNumberIsTooSmall(int zahleneingabe) throws IOException {

    }

    @Override
    public void inputNumberIsTooBig(int zahleneingabe) throws IOException {

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

    }

    @Override
    public void askForAsecondRound() throws IOException {

    }
}

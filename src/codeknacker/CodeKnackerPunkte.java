package codeknacker;

public class CodeKnackerPunkte implements ICodeKnackerPunkte {
    private static int punktePlayer1 = 0;
    private static int punktePlayer2 = 0;

    @Override
    public int getPunktePlayer1() {
        return punktePlayer1;
    }

    @Override
    public int getPunktePlayer2() {
        return punktePlayer2;
    }

    @Override
    public void setPunktePlayer1() {
        punktePlayer1++;
    }

    @Override
    public void setPunktePlayer2() {
        punktePlayer2++;
    }

    public void setPunktePlayer1Zero(){
        punktePlayer1 = 0;
    }
}

package codeknacker;

public class CodeKnackerPunkte implements ICodeKnackerPunkte {
    int punktePlayer1 = 0;
    int punktePlayer2 = 0;

    @Override
    public int getPunktePlayer1() {
        return this.punktePlayer1;
    }

    @Override
    public int getPunktePlayer2() {
        return this.punktePlayer2;
    }

    @Override
    public void setPunktePlayer1() {
        this.punktePlayer1++;
    }

    @Override
    public void setPunktePlayer2() {
        this.punktePlayer2++;
    }
}

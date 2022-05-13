package codeknacker;

import java.io.IOException;

public class CodeKnackerResult implements ICodeKnackerResult {
    @Override
    public String theWinnerIs() throws IOException {
        //Den konkreten Spielernamen am Ende richtig zuordnen!
        CodeKnackerPunkte punkte_player1 = new CodeKnackerPunkte();
        int sum_player1 = punkte_player1.getPunktePlayer1();
        int sum_player2 = punkte_player1.getPunktePlayer2();
        if(sum_player1>sum_player2){
            return "Alice";
        }else if(sum_player1<sum_player2){
            return "Bob";
        }else{
            return "unentschieden";
        }
    }

    @Override
    public String aRemis() throws IOException {
        return null;
    }
}

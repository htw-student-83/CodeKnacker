
package codeknacker;

import codeknackerUI.CodeKnackerUserCom;
import codeknackerUI.NetworkException;

import java.io.IOException;

public class CodeKnackerResult {

    CodeKnackerImpl impl = new CodeKnackerImpl();
    CodeKnackerStream stream = new CodeKnackerStream();
    CodeKnackerUserCom com = new CodeKnackerUserCom();

/*
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

        return "";
    }
*/
    /*
    @Override
    public String aRemis() throws IOException {
        return null;
    }
/*
    @Override
    public void feedbackOfTheRound(int checkNumber){
        switch(checkNumber){
            case 1:
                String winner1 = "Player1";
                try {
                    com.createTheUpperPartOfTheGameFrameEnd();
                    stream.saveGameResult(winner1);
                } catch (Exception | NetworkException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    com.createTheUpperPartOfTheGameFrame();
                } catch (Exception | NetworkException e) {
                    e.printStackTrace();
                }
                break;

                /*
                String winner2 = "Player2";
                System.out.println("Glückwunsch zum Sieg Player2");
                try {
                    stream.saveGameResult(winner2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //Nach einer weiteren Runde fragen!
                try {
                    com.askForAsecondRound();
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (NetworkException e) {
                    e.printStackTrace();
                }
                break;
        }
        /*
            case 3:
                String remi = "Schade, es gibt keinen Sieger.";
                System.out.println("Es gibt keinen Sieger.");
                try {
                    stream.saveGameResult(remi);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //Nach einer weiteren Runde fragen!
                askforNextRound();
                break;
            case 4:
                //Spiel wird fortgesetzt
        }
        }
    }
 */
}




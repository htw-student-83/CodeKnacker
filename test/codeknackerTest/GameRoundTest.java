package codeknackerTest;

import codeknacker.*;
import codeknackerUI.CodeKnackerUserCom;
import codeknackerUI.ICodeKnackerUserCommunication;
import codeknackerUI.NetworkException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class GameRoundTest {
    public static final String ALICE = "Alice"; //playernumber 1
    public static final String BOB = "Bob";//playernumber 2

    private ICodeKnackerStreamsTheResult object() {
        return new CodeKnackerStream();
    }

    private ICodeKnackerUserCommunication object2() {
        return new CodeKnackerUserCom();
    }

    private ICodeKnackerCheckUserNumber object6 (){
        return new CodeKnackerImpl();
    }

    private ICodeKnackerResult object4(){
        return new CodeKnackerResult();
    }

    private ICodeKnackerPunkte object5(){
        return new CodeKnackerPunkte();
    }


    //Jeder Spieler hat 3 Versuche
    @Test
    public void aWinnerTest() throws Exception, NetworkException {
        ICodeKnackerStreamsTheResult stream = this.object();
        ICodeKnackerUserCommunication userinput = this.object2();
        ICodeKnackerPunkte punkte = this.object5();
        ICodeKnackerCheckUserNumber checkInput = this.object6();
        ICodeKnackerResult result = this.object4();

        //herer to simulate a game round with an winner at the end
        //to put a final code for the simulation
        int [] code = {4,5,6};

        //Zahl X
        checkInput.checkHintNumber(2, 1);
        checkInput.checkHintNumber(1, 2);
        checkInput.checkHintNumber(4, 1);
        punkte.setPunktePlayer1();

        //Zahl Y
        checkInput.checkHintNumber(2, 2);
        checkInput.checkHintNumber(5, 1);
        punkte.setPunktePlayer1();

        //Zahl Z
        checkInput.checkHintNumber(4, 2);
        checkInput.checkHintNumber(5, 1);
        checkInput.checkHintNumber(6, 2);
        punkte.setPunktePlayer2();
        checkInput.endOfRound();
        result.feedbackOfTheRound(1);
        //How does simulate that two players are playing?
        stream.saveGameResult(ALICE);
        String resultWinner = stream.restoreGameResult();
        Assert.assertEquals("Alice", resultWinner);
    }


    @Test
    public void aWinnerTest2() throws Exception, NetworkException {

        //herer to simulate a game round with an winner at the end
        ICodeKnackerStreamsTheResult stream = this.object();
        ICodeKnackerUserCommunication userinput = this.object2();
        ICodeKnackerResult result = this.object4();
        ICodeKnackerPunkte punkte = this.object5();
        ICodeKnackerCheckUserNumber checkInput = this.object6();
        //to put a final code for the first simulation
        int [] code = {4,5,6};
        //Zahl X
        checkInput.checkHintNumber(2, 1);
        checkInput.checkHintNumber(1, 2);
        checkInput.checkHintNumber(3, 1);
        checkInput.checkHintNumber(4, 2);
        punkte.setPunktePlayer2();

        //Zahl Y
        checkInput.checkHintNumber(2, 1);
        checkInput.checkHintNumber(1, 2);
        checkInput.checkHintNumber(7, 1);
        checkInput.checkHintNumber(5, 2);
        punkte.setPunktePlayer2();

        //Zahl Z
        checkInput.checkHintNumber(2, 1);
        checkInput.checkHintNumber(1, 2);
        checkInput.checkHintNumber(6, 1);
        punkte.setPunktePlayer1();
        checkInput.endOfRound();
        result.feedbackOfTheRound(1);
        //How does simulate that two players are playing?

        stream.saveGameResult(BOB);
        String resultWinner = stream.restoreGameResult();
        Assert.assertEquals("Bob", resultWinner);
    }

    /*
    @Test
    public void aRemiTest() throws Exception {
        ICodeKnackerStreamsTheResult stream = this.object();
        ICodeKnackerUserCommunication userinput = this.object2();
        ICodeKnackerResult result = this.object4();
        ICodeKnackerPunkte punkte = this.object5();
        ICodeKnackerCheckUserNumber checkInput = this.object6();
        //herer to simulate a game round with a remi at the end
        int [] code = {4,5,6};
        //Zahl X
        checkInput.checkHintNumber(2, 1);
        checkInput.checkHintNumber(1, 2);
        checkInput.checkHintNumber(3, 1);
        checkInput.checkHintNumber(4, 2);
        punkte.setPunktePlayer2();

        //Zahl Y
        checkInput.checkHintNumber(2, 1);
        checkInput.checkHintNumber(1, 2);
        checkInput.checkHintNumber(5, 1);
        punkte.setPunktePlayer1();

        //Zahl Z
        checkInput.checkHintNumber(2, 1);
        checkInput.checkHintNumber(1, 2);
        checkInput.checkHintNumber(4, 1);
        checkInput.checkHintNumber(3, 2);
        checkInput.checkHintNumber(8, 1);
        checkInput.checkHintNumber(7, 2);
        checkInput.endOfRound();
        result.feedbackOfTheRound(1);
        //How does simulate that two players are playing?
        String resultGame = result.aRemis();
        stream.saveGameResult(resultGame);
        String savedResultGame = stream.restoreGameResult();
        Assert.assertEquals("Unentschieden", savedResultGame);
    }
     */
    @Test
    public void continueTest() throws Exception, NetworkException {
        ICodeKnackerStreamsTheResult stream = this.object();
        ICodeKnackerUserCommunication userinput = this.object2();
        ICodeKnackerResult result = this.object4();
        ICodeKnackerPunkte punkte = this.object5();
        ICodeKnackerCheckUserNumber checkInput = this.object6();
        //herer to simulate a game round with a remi at the end
        int[] code = {4, 5, 6};
        //Zahl X
        checkInput.checkHintNumber(2, 1);
        checkInput.checkHintNumber(1, 2);
        checkInput.checkHintNumber(3, 1);
        checkInput.checkHintNumber(4, 2);
        punkte.setPunktePlayer2();
        checkInput.endOfRound();
        result.feedbackOfTheRound(2);
    }

    @Test(expected = WrongStatusException.class)
    public void aGameRoundWithAStatusFaild() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber checkInput = this.object6();
        int[] code = {4, 5, 6};
        //Zahl X
        checkInput.checkHintNumber(2, 1);
        checkInput.checkHintNumber(1, 1);
    }

    @Test(expected = WrongStatusException.class)
    public void aGameRoundWithAStatusFaild2() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber checkInput = this.object6();
        int[] code = {4, 5, 6};
        //Zahl X
        checkInput.checkHintNumber(2, 2);
        checkInput.checkHintNumber(1, 2);
    }
}

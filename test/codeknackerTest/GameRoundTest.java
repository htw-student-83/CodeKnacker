package codeknackerTest;

import codeknacker.*;
import codeknackerUI.CodeKnackerUserCom;
import codeknackerUI.ICodeKnackerUserCommunication;
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
    public void aWinnerTest() throws IOException, StatusException, WrongStatusException {
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
        int endOfGame = checkInput.endOfRound();
        //How does simulate that two players are playing?
        String winner = result.theWinnerIs();
        stream.saveGameResult(winner);
        String resultWinner = stream.restoreGameResult();
        Assert.assertEquals(1, endOfGame);
        Assert.assertEquals("Alice", resultWinner);
    }


    @Test
    public void aWinnerTest2() throws IOException, StatusException, WrongStatusException {
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
        int endOfGame = checkInput.endOfRound();
        //How does simulate that two players are playing?
        String winner = result.theWinnerIs();
        stream.saveGameResult(winner);
        Assert.assertEquals(1, endOfGame);
        String resultWinner = stream.restoreGameResult();
        Assert.assertEquals("Bob", resultWinner);
    }

    @Test
    public void aRemiTest() throws IOException, WrongStatusException {
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
        int endOfGame = checkInput.endOfRound();
        //How does simulate that two players are playing?
        String resultGame = result.aRemis();
        stream.saveGameResult(resultGame);
        String savedResultGame = stream.restoreGameResult();
        Assert.assertEquals(2, endOfGame);
        Assert.assertEquals("Unentschieden", savedResultGame);
    }

    @Test
    public void continueTest() throws IOException, WrongStatusException {
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
        int checkNumber = checkInput.endOfRound();
        Assert.assertEquals(3,checkNumber);
    }

    @Test(expected = WrongStatusException.class)
    public void aGameRoundWithAStatusFaild() throws IOException, WrongStatusException {
        ICodeKnackerCheckUserNumber checkInput = this.object6();
        int[] code = {4, 5, 6};
        //Zahl X
        checkInput.checkHintNumber(2, 1);
        checkInput.checkHintNumber(1, 1);
    }

    @Test(expected = WrongStatusException.class)
    public void aGameRoundWithAStatusFaild2() throws IOException, WrongStatusException {
        ICodeKnackerCheckUserNumber checkInput = this.object6();
        int[] code = {4, 5, 6};
        //Zahl X
        checkInput.checkHintNumber(2, 2);
        checkInput.checkHintNumber(1, 2);
    }
}

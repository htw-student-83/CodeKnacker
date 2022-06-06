package codeknackerTest;

import codeknacker.*;
import codeknackerUI.CodeKnackerUserCom;
import codeknackerUI.ICodeKnackerUserCommunication;
import codeknackerUI.NetworkException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

public class GameRoundTest {
    public static final String ALICE = "Alice"; //playernumber 1
    public static final String BOB = "Bob";//playernumber 2
    public static final String REMI = "niemand";


    //den Objekten passende Namen geben!
    private ICodeKnackerStreamsTheResult resultStreamObject() {
        return new CodeKnackerStream();
    }

    private ICodeKnackerUserCommunication communicationObject() {
        return new CodeKnackerUserCom();
    }

    private ICodeKnackerCheckUserNumber checkUserNumberObject(){
        return new CodeKnackerImpl();
    }

    /*
    private ICodeKnackerResult resultObject(){
        return new CodeKnackerResult();
    }
     */

    private ICodeKnackerPunkte pointObject(){
        return new CodeKnackerPunkte();
    }


    @BeforeEach
    public void changeToInitialValues(){
        CodeKnackerImpl.setI();
        CodeKnackerPunkte initialPunkte = new CodeKnackerPunkte();
        initialPunkte.setPunktePlayer1Zero();
    }

    //Jeder Spieler hat 3 Versuche
    @Test
    public void aWinnerTest() throws Exception, NetworkException {
        ICodeKnackerStreamsTheResult stream = this.resultStreamObject();
        ICodeKnackerUserCommunication userinput = this.communicationObject();
        ICodeKnackerPunkte punkte = this.pointObject();
        ICodeKnackerCheckUserNumber checkInput = this.checkUserNumberObject();

        //herer to simulate a game round with a winner at the end
        //to put a final code for the simulation
        int [] code = {4,5,6};

        //Zahl X
        checkInput.checkHintNumberForTesting(2, 1);
        checkInput.checkHintNumberForTesting(1, 2);
        checkInput.checkHintNumberForTesting(4, 1);
        punkte.setPunktePlayer1();

        //Zahl Y
        checkInput.checkHintNumberForTesting(2, 2);
        checkInput.checkHintNumberForTesting(5, 1);
        punkte.setPunktePlayer1();

        //Zahl Z
        checkInput.checkHintNumberForTesting(4, 2);
        checkInput.checkHintNumberForTesting(5, 1);
        checkInput.checkHintNumberForTesting(6, 2);
        punkte.setPunktePlayer2();
        //checkInput.won();
        //How does simulate that two players are playing?
        //stream.saveGameResult(ALICE);
        String resultWinner = stream.restoreGameResult();
        Assert.assertEquals(ALICE, resultWinner);
    }


    @Test
    public void aWinnerTest2() throws Exception, NetworkException {
        //herer to simulate a game round with a winner at the end
        ICodeKnackerStreamsTheResult stream = this.resultStreamObject();
        ICodeKnackerUserCommunication userinput = this.communicationObject();
        ICodeKnackerPunkte punkte = this.pointObject();
        ICodeKnackerCheckUserNumber checkInput = this.checkUserNumberObject();
        //to put a final code for the first simulation
        int [] code = {4,5,6};
        //Zahl X
        checkInput.checkHintNumberForTesting(2, 1);
        checkInput.checkHintNumberForTesting(1, 2);
        checkInput.checkHintNumberForTesting(3, 1);
        checkInput.checkHintNumberForTesting(4, 2);
        punkte.setPunktePlayer2();

        //Zahl Y
        checkInput.checkHintNumberForTesting(2, 1);
        checkInput.checkHintNumberForTesting(1, 2);
        checkInput.checkHintNumberForTesting(7, 1);
        checkInput.checkHintNumberForTesting(5, 2);
        punkte.setPunktePlayer2();

        //Zahl Z
        checkInput.checkHintNumberForTesting(2, 1);
        checkInput.checkHintNumberForTesting(1, 2);
        checkInput.checkHintNumberForTesting(6, 1);
        punkte.setPunktePlayer1();
        //checkInput.won();
        //How does simulate that two players are playing?
        String resultWinner = stream.restoreGameResult();
        Assert.assertEquals(BOB, resultWinner);
    }

    @Test
    public void aRemiTest() throws Exception, NetworkException {
        ICodeKnackerStreamsTheResult stream = this.resultStreamObject();
        ICodeKnackerUserCommunication userinput = this.communicationObject();
        ICodeKnackerPunkte punkte = this.pointObject();
        ICodeKnackerCheckUserNumber checkInput = this.checkUserNumberObject();
        //herer to simulate a game round with a remi at the end
        int [] code = {4,5,6};
        //Zahl X
        checkInput.checkHintNumberForTesting(2, 1);
        checkInput.checkHintNumberForTesting(1, 2);
        checkInput.checkHintNumberForTesting(3, 1);
        checkInput.checkHintNumberForTesting(4, 2);
        punkte.setPunktePlayer2();

        //Zahl Y
        checkInput.checkHintNumberForTesting(2, 1);
        checkInput.checkHintNumberForTesting(1, 2);
        checkInput.checkHintNumberForTesting(5, 1);
        punkte.setPunktePlayer1();

        //Zahl Z
        checkInput.checkHintNumberForTesting(2, 1);
        checkInput.checkHintNumberForTesting(1, 2);
        checkInput.checkHintNumberForTesting(4, 1);
        checkInput.checkHintNumberForTesting(3, 2);
        checkInput.checkHintNumberForTesting(8, 1);
        checkInput.checkHintNumberForTesting(7, 2);
        //checkInput.won();
        //How does simulate that two players are playing?
        String savedResultGame = stream.restoreGameResult();
        Assert.assertEquals(REMI, savedResultGame);
    }

    @Test
    public void continueTest() throws Exception, NetworkException {
        ICodeKnackerStreamsTheResult stream = this.resultStreamObject();
        ICodeKnackerUserCommunication userinput = this.communicationObject();
        ICodeKnackerPunkte punkte = this.pointObject();
        ICodeKnackerCheckUserNumber checkInput = this.checkUserNumberObject();
        //herer to simulate a game round with a remi at the end
        int[] code = {4, 5, 6};
        //Zahl X
        checkInput.checkHintNumberForTesting(2, 1);
        checkInput.checkHintNumberForTesting(1, 2);
        checkInput.checkHintNumberForTesting(3, 1);
        checkInput.checkHintNumberForTesting(4, 2);
        punkte.setPunktePlayer2();
        //Assert.assertTrue(Player1Status!=CodeKnackerStatus.ENDED);
        //Assert.assertTrue(Player2Status!=CodeKnackerStatus.ENDED);
    }

    @Test(expected = WrongStatusException.class)
    public void aGameRoundWithAStatusFaild() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber checkInput = this.checkUserNumberObject();
        int[] code = {4, 5, 6};
        //Zahl X
        checkInput.checkHintNumberForTesting(2, 1);
        checkInput.checkHintNumberForTesting(1, 1);
    }

    @Test(expected = WrongStatusException.class)
    public void aGameRoundWithAStatusFaild2() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber checkInput = this.checkUserNumberObject();
        int[] code = {4, 5, 6};
        //Zahl X
        checkInput.checkHintNumberForTesting(2, 2);
        checkInput.checkHintNumberForTesting(1, 2);
    }
}

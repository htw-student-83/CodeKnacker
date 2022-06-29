package codeknackerTest;

import codeknacker.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class GameRoundTest {
    public static final String DANIEL = "Daniel"; //playernumber 1
    public static final String ULE = "Ule";//playernumber 2
    public static final String REMI = "niemand";


    //den Objekten passende Namen geben!
    private ICodeKnackerStreamsTheResult resultStreamObject() {
        return new CodeKnackerStream();
    }
    private ICodeKnackerCheckUserNumber checkUserNumberObject(){
        return new CodeKnackerImpl();
    }
    private ICodeKnackerRandomNumbers randomNumberobject(){
        return new CodeKnackerRandomNumber();
    }


    @BeforeEach
    public void changeToInitialValues(){
        CodeKnackerPunkte initialPunkte = new CodeKnackerPunkte();
        CodeKnackerImpl.setI();
        initialPunkte.setPunktePlayer1Zero();
        initialPunkte.setPunktePlayer2Zero();
    }

    @Test
    public void aWinnerTest() throws Exception{
        ICodeKnackerStreamsTheResult stream = this.resultStreamObject();
        ICodeKnackerCheckUserNumber checkInput = this.checkUserNumberObject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        ICodeKnackerPunkte punkte = new CodeKnackerPunkte();
        randomNumber.setRandomNumbersInArray(4,5,6);

        //Zahl X
        checkInput.checkHintNumberForTesting2(2, CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(1, CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(4, CodeKnackerStatus.PLAYER1_ACTIVE);

        //Zahl Y
        checkInput.checkHintNumberForTesting2(2, CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(5, CodeKnackerStatus.PLAYER1_ACTIVE);

        //Zahl Z
        checkInput.checkHintNumberForTesting2(4, CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(5, CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(6, CodeKnackerStatus.PLAYER2_ACTIVE);

        String resultWinner = stream.restoreGameResult();
        int points_player1 = punkte.getPunktePlayer1();
        int points_player2 = punkte.getPunktePlayer2();
        Assertions.assertEquals(2, points_player1);
        Assertions.assertEquals(1, points_player2);
        Assert.assertEquals(DANIEL, resultWinner);
    }


    @Test
    public void aWinnerTest2() throws Exception {
        ICodeKnackerStreamsTheResult stream = this.resultStreamObject();
        ICodeKnackerCheckUserNumber checkInput = this.checkUserNumberObject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();

        randomNumber.setRandomNumbersInArray(4,5,6);

        //Zahl X
        checkInput.checkHintNumberForTesting2(2,CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(1,CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(3,CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(4,CodeKnackerStatus.PLAYER2_ACTIVE);

        //Zahl Y
        checkInput.checkHintNumberForTesting2(2,CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(1,CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(7,CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(5,CodeKnackerStatus.PLAYER2_ACTIVE);

        //Zahl Z
        checkInput.checkHintNumberForTesting2(2,CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(1,CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(6,CodeKnackerStatus.PLAYER1_ACTIVE);

        String resultWinner = stream.restoreGameResult();
        Assert.assertEquals(ULE, resultWinner);
    }

    @Test
    public void theBestRoundForOnePlayerTest() throws Exception {
        ICodeKnackerStreamsTheResult stream = this.resultStreamObject();
        ICodeKnackerCheckUserNumber checkInput = this.checkUserNumberObject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        ICodeKnackerPunkte punkte = new CodeKnackerPunkte();

        randomNumber.setRandomNumbersInArray(4,5,6);

        //Zahl X
        checkInput.checkHintNumberForTesting2(2,CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(1,CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(3,CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(4,CodeKnackerStatus.PLAYER2_ACTIVE);

        //Zahl Y
        checkInput.checkHintNumberForTesting2(2,CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(1,CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(7,CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(5,CodeKnackerStatus.PLAYER2_ACTIVE);

        //Zahl Z
        checkInput.checkHintNumberForTesting2(2,CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(1,CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(3,CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(6,CodeKnackerStatus.PLAYER2_ACTIVE);

        String resultWinner = stream.restoreGameResult();
        int points_player2 = punkte.getPunktePlayer2();
        Assertions.assertEquals(3, points_player2);
        Assert.assertEquals(ULE, resultWinner);
    }

    @Test
    public void aRemiTest() throws Exception {
        ICodeKnackerStreamsTheResult stream = this.resultStreamObject();
        ICodeKnackerCheckUserNumber checkInput = this.checkUserNumberObject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        ICodeKnackerPunkte punkte = new CodeKnackerPunkte();

        randomNumber.setRandomNumbersInArray(4,5,6);

        //Zahl X
        checkInput.checkHintNumberForTesting2(2, CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(1, CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(3, CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(4, CodeKnackerStatus.PLAYER2_ACTIVE);

        //Zahl Y
        checkInput.checkHintNumberForTesting2(2, CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(1, CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(5, CodeKnackerStatus.PLAYER1_ACTIVE);

        //Zahl Z
        checkInput.checkHintNumberForTesting2(2, CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(1, CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(4, CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(3, CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(8, CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(7, CodeKnackerStatus.PLAYER1_ACTIVE);
        int point_player1 = punkte.getPunktePlayer1();
        int point_player2 = punkte.getPunktePlayer2();
        String savedResultGame = stream.restoreGameResult();
        Assertions.assertEquals(1, point_player1);
        Assertions.assertEquals(1, point_player2);
        Assert.assertEquals(REMI, savedResultGame);
    }

    @Test
    public void continueTest() throws Exception{
        ICodeKnackerCheckUserNumber checkInput = this.checkUserNumberObject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();

        randomNumber.setRandomNumbersInArray(4,5,6);

        //Zahl X
        checkInput.checkHintNumberForTesting2(2,CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(1,CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(3,CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(4,CodeKnackerStatus.PLAYER2_ACTIVE);

        Assertions.assertNotSame(ChangeStatus.getStatus(), CodeKnackerStatus.ENDED);
    }


    @Test(expected = WrongStatusException.class)
    public void aGameRoundWithAStatusFaild() throws Exception {
        ICodeKnackerCheckUserNumber checkInput = this.checkUserNumberObject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        randomNumber.setRandomNumbersInArray(4,5,6);

        //Zahl X
        checkInput.checkHintNumberForTesting2(2, CodeKnackerStatus.PLAYER1_ACTIVE);
        checkInput.checkHintNumberForTesting2(1, CodeKnackerStatus.PLAYER1_ACTIVE);
    }

    @Test(expected = WrongStatusException.class)
    public void aGameRoundWithAStatusFaild2() throws Exception{
        ICodeKnackerCheckUserNumber checkInput = this.checkUserNumberObject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        randomNumber.setRandomNumbersInArray(4,5,6);

        //Zahl X
        checkInput.checkHintNumberForTesting2(2, CodeKnackerStatus.PLAYER2_ACTIVE);
        checkInput.checkHintNumberForTesting2(1, CodeKnackerStatus.PLAYER2_ACTIVE);
    }
}

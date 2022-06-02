package codeknackerTest;

import codeknacker.*;
import codeknackerUI.NetworkException;
import org.junit.Assert;
import org.junit.Test;


public class InputCheckTest {
    int hintNumbertest1 = 4;
    int hintNumbertest2 = 1;
    int hintNumbertest3 = 2;

    //den Objekten passende Namen geben!
    private ICodeKnackerCheckUserNumber implobject() {
        return new CodeKnackerImpl();
    }

    private ICodeKnackerRandomNumbers randomNumberobject(){
        return new CodeKnackerRandomNumber();
    }

    private ICodeKnackerPunkte punkteobject(){
        return new CodeKnackerPunkte();
    }


    @Test
    public void theInputNumberIsWrong() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber input = this.implobject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result =  input.checkHintNumberForTesting(hintNumbertest1, 1);
        Assert.assertFalse(result);
    }


    @Test
    public void theInputNumberIsWrongWithNoPoint() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber input = this.implobject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        ICodeKnackerPunkte punkte = this.punkteobject();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result = input.checkHintNumberForTesting(hintNumbertest1, 1);
        int pruefZahl = punkte.getPunktePlayer1();
        Assert.assertFalse(result);
        Assert.assertEquals(0, pruefZahl);
    }


    @Test
    public void oneNumberIsFoundWithGettingPoint() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber input = this.implobject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        ICodeKnackerPunkte punkte = this.punkteobject();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result = input.checkHintNumberForTesting(hintNumbertest2, 1);
        punkte.setPunktePlayer1();
        int punktPruef  = punkte.getPunktePlayer1();
        Assert.assertTrue(result);
        Assert.assertEquals(1, punktPruef);
    }


    @Test
    public void firstNumberIsFoundWithoutWin() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber input = this.implobject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        CodeKnackerImpl impl = new CodeKnackerImpl();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result = input.checkHintNumberForTesting(hintNumbertest2, 1);
        impl.setI();
        Assert.assertTrue(result);
        //Assert.assertTrue(Player1Status!=CodeKnackerStatus.ENDED);
    }

    @Test
    public void secondNumberIsFoundWithoutWin() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber input = this.implobject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        CodeKnackerImpl impl = new CodeKnackerImpl();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result1 = input.checkHintNumberForTesting(hintNumbertest2, 1);
        impl.setI();
        boolean result2 = input.checkHintNumberForTesting(hintNumbertest3, 2);
        impl.setI();
        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        //Assert.assertTrue(Player1Status!=CodeKnackerStatus.ENDED);
        //Assert.assertTrue(Player2Status!=CodeKnackerStatus.ENDED);
    }
}

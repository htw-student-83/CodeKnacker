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
    private ICodeKnackerCheckUserNumber object() {
        return new CodeKnackerImpl();
    }

    private ICodeKnackerRandomNumbers object3(){
        return new CodeKnackerRandomNumber();
    }

    private ICodeKnackerPunkte object4(){
        return new CodeKnackerPunkte();
    }

    private ICodeKnackerCheckUserNumber object5(){
        return new CodeKnackerImpl();
    }

    @Test
    public void theInputNumberIsWrong() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber input = this.object();
        ICodeKnackerRandomNumbers randomNumber = this.object3();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result =  input.checkHintNumber(hintNumbertest1, 1);
        Assert.assertFalse(result);
    }


    @Test
    public void theInputNumberIsWrongWithNoPoint() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber input = this.object();
        ICodeKnackerRandomNumbers randomNumber = this.object3();
        ICodeKnackerPunkte punkte = this.object4();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result = input.checkHintNumber(hintNumbertest1, 1);
        int pruefZahl = punkte.getPunktePlayer1();
        Assert.assertFalse(result);
        Assert.assertEquals(0, pruefZahl);
    }


    @Test
    public void oneNumberIsFoundWithGettingPoint() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber input = this.object();
        ICodeKnackerRandomNumbers randomNumber = this.object3();
        ICodeKnackerPunkte punkte = this.object4();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result = input.checkHintNumber(hintNumbertest2, 1);
        punkte.setPunktePlayer1();
        int punktPruef  = punkte.getPunktePlayer1();
        Assert.assertTrue(result);
        Assert.assertEquals(1, punktPruef);
    }


    @Test
    public void firstNumberIsFoundWithoutWin() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber input = this.object();
        ICodeKnackerRandomNumbers randomNumber = this.object3();
        ICodeKnackerResult result = new CodeKnackerResult();
        randomNumber.setRandomNumbersInArray(1,2,3);
        input.checkHintNumber(hintNumbertest2, 1);
        input.endOfRound();
        result.feedbackOfTheRound(2);
    }

    @Test
    public void secondNumberIsFoundWithoutWin() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber input = this.object();
        ICodeKnackerRandomNumbers randomNumber = this.object3();
        CodeKnackerImpl impl = new CodeKnackerImpl();
        randomNumber.setRandomNumbersInArray(1,2,3);
        input.checkHintNumber(hintNumbertest2, 1);
        impl.setI();
        boolean feedback = input.checkHintNumber(hintNumbertest3, 2);
        input.endOfRound();
        Assert.assertTrue(feedback);
    }
}

package codeknackerTest;

import codeknacker.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class InputCheckTest {
    int hintNumbertest1 = 4;
    int hintNumbertest2 = 1;


    private ICodeKnackerCheckUserNumber object() {
        return new CodeKnackerImpl();
    }

    private ICodeKnackerRandomNumbers object3(){
        return new CodeKnackerRandomNumber();
    }

    private ICodeKnackerPunkte object4(){
        return new CodeKnackerPunkte();
    }

    @Test
    public void theInputNumberIsWrong() throws WrongStatusException, StatusException, IOException {
        ICodeKnackerCheckUserNumber input = this.object();
        ICodeKnackerRandomNumbers randomNumber = this.object3();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result =  input.checkHintNumber(hintNumbertest1, 1);
        Assert.assertFalse(result);
    }


    @Test
    public void theInputNumberIsWrongWithNoPoint() throws WrongStatusException, StatusException, IOException {
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
    public void oneNumberIsFoundWithGettingPoint() throws WrongStatusException, StatusException, IOException {
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
    public void oneNumberIsFoundWithoutWin() throws WrongStatusException, StatusException, IOException {
        ICodeKnackerCheckUserNumber input = this.object();
        ICodeKnackerRandomNumbers randomNumber = this.object3();
        randomNumber.setRandomNumbersInArray(1,2,3);
        input.checkHintNumber(hintNumbertest2, 1);
        int result = input.endOfRound();
        Assert.assertEquals(3, result);
    }
}

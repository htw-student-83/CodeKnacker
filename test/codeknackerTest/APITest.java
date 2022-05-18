package codeknackerTest;

import codeknacker.*;
import codeknackerUI.CodeKnackerUserCom;
import codeknackerUI.ICodeKnackerUserCommunication;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class APITest {
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
    public void theInputNumberIsWrong() throws WrongStatusException, StatusException {
        ICodeKnackerCheckUserNumber input = this.object();
        ICodeKnackerRandomNumbers randomNumber = this.object3();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result =  input.checkHintNumber(hintNumbertest1, 1);
        Assert.assertFalse(result);
    }


    @Test
    public void theInputNumberIsWrong2() throws WrongStatusException, StatusException {
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
    public void oneNumberIsFound() throws WrongStatusException, StatusException {
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
    public void oneNumberIsFound2() throws WrongStatusException, StatusException, IOException {
        ICodeKnackerCheckUserNumber input = this.object();
        ICodeKnackerRandomNumbers randomNumber = this.object3();
        randomNumber.setRandomNumbersInArray(1,2,3);
        input.checkHintNumber(hintNumbertest2, 1);
        boolean result = input.won();
        Assert.assertFalse(result);
    }
}

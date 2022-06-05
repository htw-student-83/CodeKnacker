package codeknackerTest;

import codeknacker.*;
import codeknackerUI.NetworkException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputCheckTest {
    //Bitte merken: bei jedem Testszenario muss jede zu incrementierte Variable zu Beginn auf den Startwert gebracht werden!
    int hintNumber1 = 4;
    int hintNumber2 = 1;
    int hintNumber3 = 2;

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



    @BeforeEach
    public void changeToInitialValues(){
        CodeKnackerImpl.setI();
        CodeKnackerPunkte initialPunkte = new CodeKnackerPunkte();
        initialPunkte.setPunktePlayer1Zero();
    }


    @Test
    void theInputNumberIsWrong() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber input = this.implobject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result =  input.checkHintNumberForTesting(hintNumber1, 1);
        Assertions.assertFalse(result);
    }


    @Test
    void theInputNumberIsWrongWithNoPoint() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber input = this.implobject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        ICodeKnackerPunkte punkte = this.punkteobject();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result = input.checkHintNumberForTesting(hintNumber1, 1);
        int point = punkte.getPunktePlayer1();
        Assertions.assertFalse(result);
        Assertions.assertEquals(0,  point);
    }


    @Test
    void oneNumberIsFoundWithGettingPoint() throws Exception, NetworkException {
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        ICodeKnackerPunkte punkte = this.punkteobject();
        ICodeKnackerCheckUserNumber input = this.implobject();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result = input.checkHintNumberForTesting(hintNumber2, 1);
        int point = punkte.getPunktePlayer1();
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, point);
    }


    @Test
    void twoInputNumbersAreRightWithGettingPoints() throws Exception, NetworkException {
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        ICodeKnackerPunkte punkte = this.punkteobject();
        ICodeKnackerCheckUserNumber input = this.implobject();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result1 = input.checkHintNumberForTesting(hintNumber2, 1);
        boolean result2 = input.checkHintNumberForTesting(hintNumber3, 1);
        int point = punkte.getPunktePlayer1();
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
        Assertions.assertEquals(2, point);
    }

    @Test
    void twoInputNumbersAreWrongWithNoPoints() throws Exception, NetworkException {
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        ICodeKnackerPunkte punkte = this.punkteobject();
        ICodeKnackerCheckUserNumber input = this.implobject();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result1 = input.checkHintNumberForTesting(hintNumber1, 1);
        boolean result2 = input.checkHintNumberForTesting(hintNumber3, 1);
        int point = punkte.getPunktePlayer1();
        Assertions.assertFalse(result1);
        Assertions.assertFalse(result2);
        Assertions.assertEquals(0, point);
    }


    @Test
    void firstNumberIsFoundWithoutWin() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber input = this.implobject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result = input.checkHintNumberForTesting(hintNumber2, 1);
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, CodeKnackerImpl.index);
    }


    @Test
    void secondNumberIsFoundWithoutWin() throws Exception, NetworkException {
        ICodeKnackerCheckUserNumber input = this.implobject();
        ICodeKnackerRandomNumbers randomNumber = this.randomNumberobject();
        randomNumber.setRandomNumbersInArray(1,2,3);
        boolean result1 = input.checkHintNumberForTesting(hintNumber2, 1);
        boolean result2 = input.checkHintNumberForTesting(hintNumber3, 2);
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
        Assertions.assertEquals(2, CodeKnackerImpl.index);
    }
}

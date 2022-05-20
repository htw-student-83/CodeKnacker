package codeknackerTest;

import codeknacker.CodeKnackerRandomNumber;
import codeknacker.ICodeKnackerRandomNumbers;
import codeknacker.StatusException;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class CodeKnackerRandomNumberTest {

    private ICodeKnackerRandomNumbers object() {
        return new CodeKnackerRandomNumber();
    }


    @Test
    public void firstRandomNumberAtIntervall () {
        ICodeKnackerRandomNumbers randomNumber = this.object();
        int randomNumberOne = randomNumber.creationRandomNumber();
        Assert.assertTrue(randomNumberOne>=0);
        Assert.assertTrue(randomNumberOne<=9);
    }


    @Test
    public void setRandomNumbersInArray(){
        ICodeKnackerRandomNumbers randomNumber = this.object();
        final int MAXSIZEOFLIST = 3;
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i<MAXSIZEOFLIST; i++){
            randomNumberList.add(randomNumber.creationRandomNumber());
        }
        Assert.assertEquals(3, randomNumberList.size());
    }


    @Test
    public void isDuplicate() throws StatusException {
        ICodeKnackerRandomNumbers randomNumber = this.object();
        int zahlX = 1;
        int zahlY = 3;
        int zahlZ = 2;
        boolean result = randomNumber.isAduplicate(zahlX,zahlY,zahlZ);
        Assert.assertFalse(result);
    }


    @Test
    public void isDuplicate2() throws StatusException {
        ICodeKnackerRandomNumbers randomNumber = this.object();
        int zahlX = 1;
        int zahlY = 3;
        int zahlZ = 1;
        boolean result = randomNumber.isAduplicate(zahlX,zahlY,zahlZ);
        Assert.assertTrue(result);
    }


    @Test
    public void isDuplicate3() throws StatusException {
        ICodeKnackerRandomNumbers randomNumber = this.object();
        int zahlX = 1;
        int zahlY = 1;
        int zahlZ = 3;
        boolean result = randomNumber.isAduplicate(zahlX,zahlY,zahlZ);
        Assert.assertTrue(result);
    }


    @Test
    public void isDuplicate4() throws StatusException {
        ICodeKnackerRandomNumbers randomNumber = this.object();
        int zahlX = 3;
        int zahlY = 1;
        int zahlZ = 1;
        boolean result = randomNumber.isAduplicate(zahlX,zahlY,zahlZ);
        Assert.assertTrue(result);
    }
}

package codeknackerTest;

import codeknacker.CodeKnackerRandomNumber;
import codeknacker.CodeKnackerRandomNumbers;
import codeknacker.StatusException;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class CodeKnackerRandomNumberTest {

    private CodeKnackerRandomNumbers object() {
        return new CodeKnackerRandomNumber();
    }

    @Test
    public void firstRandomNumberAtIntervall () throws StatusException {
        CodeKnackerRandomNumbers randomNumber = this.object();
        int randomNumberOne = randomNumber.createRandomNumbers();
        Assert.assertTrue(randomNumberOne>=0);
        Assert.assertTrue(randomNumberOne<10);
    }


    @Test
    public void setRandomNumbersInArray() throws StatusException {
        CodeKnackerRandomNumbers randomNumber = this.object();
        final int MAXSIZEOFLIST = 3;
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i<MAXSIZEOFLIST; i++){
            randomNumberList.add(randomNumber.createRandomNumbers());
        }
        Assert.assertEquals(3, randomNumberList.size());
    }


    @Test
    public void isDuplicateInTheArray1() throws StatusException {
        CodeKnackerRandomNumbers randomNumber = this.object();
        int [] testArray = {1,2,3};
        boolean result = randomNumber.isAduplicateInTheArray(testArray);
        Assert.assertFalse(result);
    }


    @Test
    public void isDuplicateInTheArray2() throws StatusException {
        CodeKnackerRandomNumbers randomNumber = this.object();
        int [] testArray = {1,1,3};
        boolean result = randomNumber.isAduplicateInTheArray(testArray);
        Assert.assertTrue(result);
    }


    @Test
    public void isDuplicateInTheArray4() throws StatusException {
        CodeKnackerRandomNumbers randomNumber = this.object();
        int [] testArray = {1,3,1};
        boolean result = randomNumber.isAduplicateInTheArray(testArray);
        Assert.assertTrue(result);
    }



    @Test
    public void isDuplicateInTheArray3() throws StatusException {
        CodeKnackerRandomNumbers randomNumber = this.object();
        int [] testArray = {3,1,1};
        boolean result = randomNumber.isAduplicateInTheArray(testArray);
        Assert.assertTrue(result);
    }
}

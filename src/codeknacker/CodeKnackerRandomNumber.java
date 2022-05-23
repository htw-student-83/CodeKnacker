package codeknacker;

import java.util.Random;

public class CodeKnackerRandomNumber implements ICodeKnackerRandomNumbers {
    public int[] code2 = {3, 2, 1};
    public static int[] code = new int[3];

    @Override
    public void createThreeUniqueRandomNumbers() throws StatusException {
        int randomNumberOne, randomNumberTwo, randomNumberThree;
        randomNumberOne = creationRandomNumber();
        randomNumberTwo = creationRandomNumber();
        randomNumberThree = creationRandomNumber();
        if(!isDuplicate(randomNumberOne, randomNumberTwo, randomNumberThree)){
            setRandomNumbersInArray(randomNumberOne, randomNumberTwo, randomNumberThree);
        }else{
            createThreeUniqueRandomNumbers();
        }
    }

    @Override
    public void setRandomNumbersInArray(int randomNumberOne, int randomNumberTwo, int randomNumberThree) throws StatusException {
        code[0] = randomNumberOne;
        code[1] = randomNumberTwo;
        code[2] = randomNumberThree;
    }

    @Override
    public int creationRandomNumber() {
        Random zufall = new Random();
        double zahl = (zufall.nextDouble()*10-1)+1;
        int randomNumber = (int) Math.round(zahl);
        return randomNumber;
    }

    @Override
    public int getElement(int i) {
        return code[i];
    }

    @Override
    public boolean isDuplicate(int x, int y, int z) throws StatusException {
        return x==y || x==z || y==z;
    }
}

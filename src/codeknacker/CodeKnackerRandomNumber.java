package codeknacker;

public class CodeKnackerRandomNumber implements ICodeKnackerRandomNumbers {
    //public int[] code2 = new int[3];
    public static int[] code = new int[3];

    @Override
    public void createThreeUniqueRandomNumbers() {
        int randomNumberOne, randomNumberTwo, randomNumberThree;
        randomNumberOne = creationRandomNumber();
        randomNumberTwo = creationRandomNumber();
        randomNumberThree = creationRandomNumber();
        if(!isDuplicate(randomNumberOne, randomNumberTwo, randomNumberThree)){
            setRandomNumbersInArray(randomNumberOne, randomNumberTwo, randomNumberThree);
        }else{
            //Ohne den else-Zweig wird das Array mit den Standardwert 0 befüllt
            createThreeUniqueRandomNumbers();
        }
    }

    @Override
    public void setRandomNumbersInArray(int randomNumberOne, int randomNumberTwo, int randomNumberThree) {
        code[0] = randomNumberOne;
        code[1] = randomNumberTwo;
        code[2] = randomNumberThree;
    }

    @Override
    public int creationRandomNumber() {
        int minRandomNumber = 0;
        int maxRandomNumber = 9;
        int randomNumber = (int) Math.floor(Math.random()*(maxRandomNumber-minRandomNumber+1)+minRandomNumber);
        return randomNumber;
    }

    @Override
    public int getElement(int i) {
        return code[i];
    }

    @Override
    public boolean isDuplicate(int x, int y, int z) {
        return x==y || x==z || y==z;
    }
}

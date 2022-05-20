package codeknacker;

public class CodeKnackerRandomNumber implements ICodeKnackerRandomNumbers {
    public int[] code = new int[3];


    @Override
    public void createThreeUniqueRandomNumbers() throws StatusException {
        int randomNumberOne, randomNumberTwo, randomNumberThree;
        randomNumberOne = creationRandomNumber();
        randomNumberTwo = creationRandomNumber();
        randomNumberThree = creationRandomNumber();
        if(!isDuplicate(randomNumberOne, randomNumberTwo, randomNumberThree)){
            setRandomNumbersInArray(randomNumberOne, randomNumberTwo, randomNumberThree);
        }
    }

    @Override
    public void setRandomNumbersInArray(int randomNumberOne, int randomNumberTwo, int randomNumberThree) throws StatusException {
        this.code[0] = randomNumberOne;
        this.code[1] = randomNumberTwo;
        this.code[2] = randomNumberThree;
    }

    @Override
    public int creationRandomNumber() {
        //Das Intervall [0;9] muss noch festgelegt werden!
        int randomNumber = (int) Math.round(Math.random());
        return randomNumber;
    }

    @Override
    public int getElement(int i) {
        return this.code[i];
    }

    @Override
    public boolean isDuplicate(int x, int y, int z) throws StatusException {
        return x==y || x==z || y==z;
    }
}

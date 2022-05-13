package codeknacker;

public class CodeKnackerRandomNumber implements ICodeKnackerRandomNumbers {
    int[] finalCode = new int[3];

    @Override
    public void createThreeRandomNumbers() throws StatusException {
        int randomNumberOne = creationRandomNumber();
        int randomNumberTwo = creationRandomNumber();
        int randomNumberThree = creationRandomNumber();
        setRandomNumbersInArray(randomNumberOne, randomNumberTwo, randomNumberThree);
    }

    @Override
    public void setRandomNumbersInArray(int randomNumberOne, int randomNumberTwo, int randomNumberThree) throws StatusException {
        int[] code = {randomNumberOne, randomNumberTwo, randomNumberThree};
        //Recherchieren, ob die Übergabe korrekt ist!
        if(!isAduplicateInTheArray(code)){
           setFinalCode(code);
        }
    }

    @Override
    public boolean isAduplicateInTheArray(int [] ramdomNumbers) throws StatusException {
        for(int i = 0; i<ramdomNumbers.length; i++){
            if(ramdomNumbers[i]!=ramdomNumbers[i+1]&&ramdomNumbers[i]!=ramdomNumbers[i+2]
                    &&ramdomNumbers[i+1]!=ramdomNumbers[i+2]){
                return false;
            }
        }
        return true;
    }

    public void setFinalCode(int[] code){
        for(int i = 0; i<code.length; i++){
            finalCode[i] = code[i];
        }
    }

    public int getFinalElement(){
        for(int number : finalCode){
            return number;
        }
        return -1;
    }

    public int creationRandomNumber(){
        //Das Intervall [0;9] muss noch festgelegt werden!
        int randomNumber = (int) Math.round(Math.random());
        return randomNumber;
    }
}

package codeknacker;

public class CodeKnackerRandomNumber implements ICodeKnackerRandomNumbers {
    public int[] code = new int[3];

    @Override
    public void createThreeUniqueRandomNumbers() throws StatusException {
        /*
        int randomNumberOne, randomNumberTwo, randomNumberThree;
        //Die Schleife wird solange durchlaufen bis jede Zufallszahl einmalig ist
        do{
            randomNumberOne = creationRandomNumber();
            randomNumberTwo = creationRandomNumber();
            randomNumberThree = creationRandomNumber();
        }while(randomNumberOne==randomNumberTwo||randomNumberOne==randomNumberThree||randomNumberTwo==randomNumberThree);

        setRandomNumbersInArray(randomNumberOne, randomNumberTwo, randomNumberThree);

         */
    }

    //Diese Methode kann auf private umgestellt werden
    @Override
    public void setRandomNumbersInArray(int randomNumberOne, int randomNumberTwo, int randomNumberThree) throws StatusException {
        /*
        int[] randomNumberArray = {randomNumberOne, randomNumberTwo, randomNumberThree};
        setFinalCode(randomNumberArray);
        //Recherchieren, ob die Übergabe korrekt ist!
        //if(!isAduplicateInTheArray(code)){
        //
        //}

         */
    }

    /*
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
    */

    public void setFinalCode(int[] randomNumberArray){
        /*
        for(int i = 0; i<randomNumberArray.length; i++){
            this.code[i] = randomNumberArray[i];
        }

         */
    }

    public int getFinalElement(int index){
        return 0;
        /*

         this.code[index];

         */
    }

    public int creationRandomNumber(){
        /*
        //Das Intervall [0;9] muss noch festgelegt werden!
        int randomNumber = (int) Math.round(Math.random());
         randomNumber;

         */
        return 0;
    }
}

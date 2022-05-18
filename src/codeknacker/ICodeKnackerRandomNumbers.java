package codeknacker;

public interface ICodeKnackerRandomNumbers {

    /**
     * create three unique random numbers between 0 and 9.
     * @throws StatusException
     */
    void createThreeUniqueRandomNumbers() throws StatusException;


    /**
     * put all there created random numbers in an array.
     * @throws StatusException, if the prozess before is failed.
     */
    void setRandomNumbersInArray(int randomNumberOne, int randomNumberTwo, int randomNumberThree) throws StatusException;


    /**
     * check is every random number in the array unique
     * @return true, if that the case or not
     * @throws StatusException, if the process connection is failed.
     */
    //boolean isAduplicateInTheArray(int[] ramdomNumbers) throws StatusException;


    /**
     * create seperate random number and forwards to createThreeUniqueRandomNumbers().
     * @return a randomNumber in the intervall between 0 and 9
     */
    int creationRandomNumber();


    /**
     *
     * @param i
     * @return
     */
    int getFinalElement(int i);
}

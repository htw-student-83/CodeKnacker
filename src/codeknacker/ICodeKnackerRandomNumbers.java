package codeknacker;

public interface ICodeKnackerRandomNumbers {

    /**
     * create three unique random numbers between 0 and 9.
     * @throws StatusException, if..
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
     * create a seperate random number
     * @return a randomNumber in the intervall between 0 and 9
     */
    int creationRandomNumber();


    /**
     * to get a random number from the array
     * @param i, index, where a random number is
     * @return a randomNumber
     */
    int getElement(int i);

    /**
     * checks is in the array a duplicate
     * @param x random numberOne
     * @param y random numberTwo
     * @param z random numberThree
     * @return true, if we have a duplicate otherwise false
     */
    boolean isDuplicate(int x, int y, int z) throws StatusException;
}

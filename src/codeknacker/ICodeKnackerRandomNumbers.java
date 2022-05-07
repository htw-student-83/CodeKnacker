package codeknacker;

public interface ICodeKnackerRandomNumbers {

    /**
     * create three random numbers between 0 and 10.
     * @throws StatusException
     */
    int createRandomNumbers() throws StatusException;


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
    boolean isAduplicateInTheArray(int [] ramdomNumbers) throws StatusException;
}

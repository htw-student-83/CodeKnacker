package codeknacker;

public interface CodeKnackerRandomNumbers {

    /**
     * create three random numbers between 0 and 10.
     * @throws StatusException
     */
    void createRandomNumbers() throws StatusException;


    /**
     * put all there created random numbers in an array.
     * @throws StatusException, if the prozess before is failed.
     */
    void setRandomNumbersInArray() throws StatusException;


    /**
     * check is every random number unique
     * @return true, s if that the case or not
     * @throws StatusException, if the process connection is failed.
     */
    boolean isAduplicateInTheArray() throws StatusException;
}

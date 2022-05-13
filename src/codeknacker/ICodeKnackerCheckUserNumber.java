package codeknacker;

public interface ICodeKnackerCheckUserNumber {
    
    /**
     * to check is the players' input number same as the current number what we just are looking for
     * is the input number smaller, bigger or the right one of three numbers the user will get a feedback
     * @param number, the players' input number
     * @throws WrongStatusException, if a player input a number, but the other player is turns
     */
    void checkHintNumber(int number)throws WrongStatusException;
}

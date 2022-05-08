package codeknacker;

public interface ICodeKnackerPunkte{

    /**
     * to get the sum of points for one round for player1
     * @return sum
     */
    int getPunktePlayer1();


    /**
     * to get the sum of points for one round player2
     * @return sum
     */
    int getPunktePlayer2();


    /**
     * change the sum of points, if the player1 has found one of three numbers
     */
    void setPunktePlayer1();


    /**
     * change the sum of points, if the player2 has found one of three numbers
     */
    void setPunktePlayer2();
}

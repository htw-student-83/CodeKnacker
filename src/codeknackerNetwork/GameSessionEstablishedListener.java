package codeknackerNetwork;

public interface GameSessionEstablishedListener {
    /**
     * is called when oracle was created
     * @param oracle
     */
    void gameSessionEstablished(boolean oracle, String partnerName);
}

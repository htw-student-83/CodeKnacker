package codeknackerTest;

import codeknacker.*;
import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CodeKnackerStreamTest {
    public static final String ALICE = "Alice";
    public static final String BOB = "Bob";

    private String message = "Test1";

    private ICodeKnackerStreamsTheResult object() {
        return new CodeKnackerStream();
    }

    private ICodeKnackerUserCommunication object2() {
        return new CodeKnackerUserCom();
    }

    private ICodeKnackerRandomNumbers object3(){
        return new CodeKnackerRandomNumber();
    }

    private ICodeKnackerResult object4(){
        return new CodeKnackerResult();
    }

    private ICodeKnackerPunkte object5(){
        return new CodeKnackerPunkte();
    }


    @Test
    public void restoreResult() throws IOException {
        ICodeKnackerStreamsTheResult stream = this.object();
        String result = stream.restoreGameResult();
        Assert.assertEquals("", result);
    }

    @Test
    public void saveAmessageToTheFile() throws IOException {
        ICodeKnackerStreamsTheResult stream = this.object();
        stream.saveGameResult(message);
        String result = stream.restoreGameResult();
        Assert.assertEquals("Test1", result);
    }

    @Test
    public void aGameRoundWithAwinner() throws IOException, StatusException {
        ICodeKnackerStreamsTheResult stream = this.object();
        ICodeKnackerUserCommunication userinput = this.object2();
        ICodeKnackerPunkte punkte = this.object5();
        ICodeKnackerResult result = this.object4();
        //herer to simulate a game round with an winner at the end
        ICodeKnackerRandomNumbers randomNumbrs = this.object3();
        //to put a final code for the simulation
        int [] code = {4,5,6};

        //Zahl X
        userinput.deliveryHint(ALICE, 2);
        userinput.inputNumberIsTooSmall(2);
        userinput.deliveryHint(BOB, 9);
        userinput.inputNumberIsTooBig(9);
        userinput.deliveryHint(ALICE, 4);
        userinput.foundArandomNumber(4);
        punkte.setPunktePlayer1();

        //Zahl Y
        userinput.deliveryHint(BOB, 3);
        userinput.inputNumberIsTooSmall(3);
        userinput.deliveryHint(ALICE, 5);
        userinput.foundArandomNumber(5);
        punkte.setPunktePlayer1();

        //Zahl Z
        userinput.deliveryHint(BOB, 6);
        userinput.foundArandomNumber(6);
        punkte.setPunktePlayer2();

        //InputStream is = new ByteArrayInputStream(hint.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        //System.setIn(is);
        //userinput.foundArandomNumber();
        //How does simulate that two players are playing?
        String winner = result.theWinnerIs();
        stream.saveGameResult(winner);
        String resultWinner = stream.restoreGameResult();
        Assert.assertEquals("Alice", resultWinner);
    }


    @Test
    public void aGameRoundWithAwinner2() throws IOException, StatusException {
        //herer to simulate a game round with an winner at the end
        ICodeKnackerStreamsTheResult stream = this.object();
        ICodeKnackerUserCommunication userinput = this.object2();
        ICodeKnackerPunkte punkte = this.object5();
        ICodeKnackerResult result = this.object4();
        //ICodeKnackerRandomNumbers randomNumbrs = this.object3();
        //to put a final code for the first simulation
        int [] code = {4,5,6};
        //Zahl X
        userinput.deliveryHint(ALICE, 3);
        userinput.inputNumberIsTooSmall(3);
        userinput.deliveryHint(BOB, 4);
        userinput.foundArandomNumber(4);
        punkte.setPunktePlayer2();

        //Zahl Y
        userinput.deliveryHint(BOB, 3);
        userinput.inputNumberIsTooSmall(3);
        userinput.deliveryHint(ALICE, 7);
        userinput.inputNumberIsTooBig(code[1]);
        userinput.deliveryHint(BOB, 5);
        userinput.foundArandomNumber(5);
        punkte.setPunktePlayer2();

        //Zahl Z
        userinput.deliveryHint(ALICE, 1);
        userinput.inputNumberIsTooSmall(1);
        userinput.deliveryHint(BOB, 6);
        userinput.foundArandomNumber(6);
        punkte.setPunktePlayer2();

        //InputStream is = new ByteArrayInputStream(hint.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        //System.setIn(is);
        //userinput.foundArandomNumber();
        //How does simulate that two players are playing?
        String winner = result.theWinnerIs();
        stream.saveGameResult(winner);
        String savedWinner = stream.restoreGameResult();
        Assert.assertEquals("Bob", savedWinner);
    }

    @Test
    public void aGameRoundWithAremi() throws IOException {
        ICodeKnackerStreamsTheResult stream = this.object();
        ICodeKnackerUserCommunication userinput = this.object2();
        ICodeKnackerPunkte punkte = this.object5();
        ICodeKnackerResult result = this.object4();
        //herer to simulate a game round with a remi at the end
        int [] code = {4,5,6};
        //Zahl X
        userinput.deliveryHint(ALICE, 3);
        userinput.inputNumberIsTooSmall(3);
        userinput.deliveryHint(BOB, 4);
        userinput.foundArandomNumber(4);
        punkte.setPunktePlayer2();

        //Zahl Y
        userinput.deliveryHint(BOB, 3);
        userinput.inputNumberIsTooSmall(3);
        userinput.deliveryHint(ALICE, 5);
        userinput.foundArandomNumber(5);
        punkte.setPunktePlayer1();

        //Zahl Z
        userinput.deliveryHint(ALICE, 8);
        userinput.inputNumberIsTooBig(8);
        userinput.deliveryHint(BOB, 1);
        userinput.inputNumberIsTooSmall(1);
        userinput.deliveryHint(ALICE, 2);
        userinput.inputNumberIsTooSmall(2);
        userinput.deliveryHint(BOB, 4);
        userinput.inputNumberIsTooSmall(4);

        String resultRemi = result.aRemis();
        stream.saveGameResult(resultRemi);
        String savedResult = stream.restoreGameResult();
        Assert.assertEquals("Unentschieden", savedResult);
    }
}

package codeknackerTest;

import codeknacker.*;
import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CodeKnackerStreamTest {

    private String message = "Test1";

    private CodeKnackerStreamsTheResult object() {
        return new CodeKnackerStreamC();
    }

    private CodeKnackerUserCommunication object2() {
        return new CodeKnackerUserCom();
    }

    private CodeKnackerRandomNumbers object3(){
        return new CodeKnackerRandomNumber();
    }


    @Test
    public void restoreResult() throws IOException {
        CodeKnackerStreamsTheResult stream = this.object();
        String result = stream.restoreGameResult();
        Assert.assertEquals("", result);
    }

    @Test
    public void saveAmessageToTheFile() throws IOException {
        CodeKnackerStreamsTheResult stream = this.object();
        stream.saveGameResult(message);
        String result = stream.restoreGameResult();
        Assert.assertEquals("Test1", result);
    }

    @Test
    public void aGameRoundWithAwinner() throws IOException, StatusException {
        //herer to simulate a game round with an winner at the end
        CodeKnackerRandomNumbers randomNumbrs = this.object3();
        CodeKnackerUserCommunication userinput = this.object2();
        //to put a final code for the first simulation
        int [] code = {4,5,6};
        String hint = "4";
        InputStream is = new ByteArrayInputStream(hint.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
        userinput.foundArandomNumber();
        //How does simulate that two players are playing?
        CodeKnackerStreamsTheResult stream = this.object();
        stream.saveGameResult();
        String result = stream.restoreGameResult();
        Assert.assertEquals("Die letzte Runde gewann ... .", result);
    }

    @Test
    public void aGameRoundWithAremi() throws IOException {
        //herer to simulate a game round with a remi at the end
        CodeKnackerStreamsTheResult stream = this.object();
        stream.saveGameResult();
        String result = stream.restoreGameResult();
        Assert.assertEquals("Die letzte Runde ging unentschieden aus.", result);
    }
}

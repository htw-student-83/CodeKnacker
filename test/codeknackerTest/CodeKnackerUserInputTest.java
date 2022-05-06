package codeknackerTest;

import codeknacker.*;
import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CodeKnackerUserInputTest {
    //1. Test prüft, ob ein String eingegeben wurde

    private CodeKnackerUserCommunication object() {
        return new CodeKnackerUserCom();
    }


    @Test
    public void checkInput(){
        CodeKnackerUserCommunication userinput = this.object();
        String begriff = "test1";
        InputStream is = new ByteArrayInputStream(begriff.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen werden
        System.setIn(is);
        Assert.assertEquals("test1",userinput.yourHint2());
     }


    @Test
    public void checkInputsNumber(){
        CodeKnackerUserCommunication userinput = this.object();
        String validNumber = "1";
        InputStream is = new ByteArrayInputStream(validNumber.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
        Assert.assertEquals("1",userinput.yourHint2());
    }


    @Test
    public void checkInputsNumber2(){
        CodeKnackerUserCommunication userinput = this.object();
        String validNumber = "0";
        InputStream is = new ByteArrayInputStream(validNumber.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
        Assert.assertEquals("0",userinput.yourHint2());
    }


    @Test(expected = GameException.class)
    public void checkInputsNumber3(){
        CodeKnackerUserCommunication userinput = this.object();
        String validNumber = "10";
        InputStream is = new ByteArrayInputStream(validNumber.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
    }


    @Test(expected = GameException.class)
    public void faildInput1(){
        CodeKnackerUserCommunication userinput = this.object();
        String input = "1.1";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
    }


    @Test(expected = GameException.class)
    public void faildInput2(){
        CodeKnackerUserCommunication userinput = this.object();
        String input = "-1";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
    }


    @Test(expected = GameException.class)
    public void faildInput3(){
        CodeKnackerUserCommunication userinput = this.object();
        String input = "11";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
    }


    @Test(expected = GameException.class)
    public void faildInput4(){
        CodeKnackerUserCommunication userinput = this.object();
        String input = "1.";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
    }
}

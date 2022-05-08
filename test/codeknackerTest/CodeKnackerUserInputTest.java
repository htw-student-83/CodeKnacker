package codeknackerTest;

import codeknacker.*;
import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CodeKnackerUserInputTest {

    private ICodeKnackerUserCommunication object() {
        return new CodeKnackerUserCom();
    }

    //1. Test prüft, ob ein String eingegeben wurde
    @Test
    public void checkInput(){
        ICodeKnackerUserCommunication userinput = this.object();
        String begriff = "test1";
        InputStream is = new ByteArrayInputStream(begriff.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen werden
        System.setIn(is);
        Assert.assertEquals("test1",userinput.yourHint2());
     }


    @Test
    public void checkInputsNumber(){
        ICodeKnackerUserCommunication userinput = this.object();
        String validNumber = "0";
        InputStream is = new ByteArrayInputStream(validNumber.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
        Assert.assertEquals(0,userinput.yourHint2());
    }

    @Test
    public void checkInputsNumber2(){
        ICodeKnackerUserCommunication userinput = this.object();
        String validNumber = "1";
        InputStream is = new ByteArrayInputStream(validNumber.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
        Assert.assertEquals(1,userinput.yourHint2());
    }

    @Test
    public void checkInputsNumber3(){
        ICodeKnackerUserCommunication userinput = this.object();
        String validNumber = "2";
        InputStream is = new ByteArrayInputStream(validNumber.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
        Assert.assertEquals(2,userinput.yourHint2());
    }


    @Test
    public void checkInputsNumber4(){
        ICodeKnackerUserCommunication userinput = this.object();
        String validNumber = "3";
        InputStream is = new ByteArrayInputStream(validNumber.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
        Assert.assertEquals(3,userinput.yourHint2());
    }


    @Test
    public void checkInputsNumber5(){
        ICodeKnackerUserCommunication userinput = this.object();
        String validNumber = "4";
        InputStream is = new ByteArrayInputStream(validNumber.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
        Assert.assertEquals(4,userinput.yourHint2());
    }


    @Test
    public void checkInputsNumber6(){
        ICodeKnackerUserCommunication userinput = this.object();
        String validNumber = "5";
        InputStream is = new ByteArrayInputStream(validNumber.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
        Assert.assertEquals(5,userinput.yourHint2());
    }

    @Test
    public void checkInputsNumber7(){
        ICodeKnackerUserCommunication userinput = this.object();
        String validNumber = "6";
        InputStream is = new ByteArrayInputStream(validNumber.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
        Assert.assertEquals(6,userinput.yourHint2());
    }


    @Test
    public void checkInputsNumber8(){
        ICodeKnackerUserCommunication userinput = this.object();
        String validNumber = "7";
        InputStream is = new ByteArrayInputStream(validNumber.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
        Assert.assertEquals(7,userinput.yourHint2());
    }


    @Test
    public void checkInputsNumber9(){
        ICodeKnackerUserCommunication userinput = this.object();
        String validNumber = "8";
        InputStream is = new ByteArrayInputStream(validNumber.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
        Assert.assertEquals(8,userinput.yourHint2());
    }


    @Test
    public void checkInputsNumber10(){
        ICodeKnackerUserCommunication userinput = this.object();
        String validNumber = "9";
        InputStream is = new ByteArrayInputStream(validNumber.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
        Assert.assertEquals(9,userinput.yourHint2());
    }


    @Test(expected = GameException.class)
    public void faildInput(){
        String validNumber = "10";
        InputStream is = new ByteArrayInputStream(validNumber.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
    }


    @Test(expected = GameException.class)
    public void faildInput1(){
        String input = "1.1";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
    }


    @Test(expected = GameException.class)
    public void faildInput2(){
        String input = "-1";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
    }


    @Test(expected = GameException.class)
    public void faildInput3(){
        String input = "11";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
    }


    @Test(expected = GameException.class)
    public void faildInput4(){
        String input = "1.";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
    }
}

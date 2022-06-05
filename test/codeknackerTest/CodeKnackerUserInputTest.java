package codeknackerTest;

import codeknacker.*;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CodeKnackerUserInputTest {

    //1. Test prüft, ob ein String eingegeben wurde
    @Test(expected = GameException.class)
    public void inputnumberOutsideofIntervallTest(){
        String validNumber = "10";
        InputStream is = new ByteArrayInputStream(validNumber.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);

    }

    @Test(expected = GameException.class)
    public void inputnumberOutsideofIntervallTest2(){
        String input = "11";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
    }


    @Test(expected = GameException.class)
    public void invalidNumberTest(){
        String input = "1.1";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
    }


    @Test(expected = GameException.class)
    public void invalidNumberTest2(){
        String input = "-1";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
    }


    @Test(expected = GameException.class)
    public void invalidNumberTest3(){
        String input = "1.";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        //Sorgt dafür, das die Bytes der Variable begriff der Klasse aus Zeile 25 zugewiesen wird
        System.setIn(is);
    }
}

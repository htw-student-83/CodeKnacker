package codeknackerTest;

import codeknacker.CodeKnackerImpl;
import codeknacker.CodeKnackerUserCom;
import codeknacker.ICodeKnackerCheckUserNumber;
import codeknackerUI.ICodeKnackerUserCommunication;
import org.junit.Test;
import java.io.IOException;

public class APITest {

    private ICodeKnackerCheckUserNumber object() {
        return new CodeKnackerImpl();
    }

    private ICodeKnackerUserCommunication object2() {
        return new CodeKnackerUserCom();
    }

    @Test
    public void theInputNumberIsTooSmall() throws IOException {
        ICodeKnackerCheckUserNumber input = this.object();
        ICodeKnackerUserCommunication usercom = this.object2();
        int randomNumber = 4;
        input.checkHintNumber(3);
        usercom.inputNumberIsTooSmall(3);
    }
}

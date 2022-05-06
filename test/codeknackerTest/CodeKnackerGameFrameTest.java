package codeknackerTest;

import codeknacker.CodeKnackerDrawFrame;
import codeknacker.CodeKnackerDrawFrameC;
import codeknacker.StatusException;
import org.junit.Assert;

import java.io.IOException;

public class CodeKnackerGameFrameTest {

    private CodeKnackerDrawFrame object() {
        return new CodeKnackerDrawFrameC();
    }

    public void creationUpperFrameStart() throws StatusException {
        CodeKnackerDrawFrame frameUp = this.object();
        String frame = frameUp.createTheUpperGameFrameStart();
        Assert.assertEquals("##################################### CodeKnacker #####################################",frame);
    }

    public void creationUpperFrameEnd() throws StatusException, IOException {
        CodeKnackerDrawFrame frameUp = this.object();
        String frame = frameUp.createTheUpperGameFrameEnd();
        Assert.assertEquals("############################### CodeKnacker - Spielende ###############################",frame);
    }

    public void creationUpperFrameDown() throws StatusException, IOException {
        CodeKnackerDrawFrame frameUp = this.object();
        String frame = frameUp.createTheDownGameFrameEnd();
        Assert.assertEquals("#######################################################################################",frame);
    }
}

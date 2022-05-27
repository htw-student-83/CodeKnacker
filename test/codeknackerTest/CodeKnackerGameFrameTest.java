package codeknackerTest;

import codeknackerUI.ICodeKnackerDrawFrame;
import codeknackerUI.CodeKnackerDrawFrame;
import codeknacker.StatusException;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class CodeKnackerGameFrameTest {

    private ICodeKnackerDrawFrame objectFrame() {
        return new CodeKnackerDrawFrame();
    }

    @Test
    public void creationUpperFrameStart() throws StatusException {
        ICodeKnackerDrawFrame frameUp = this.objectFrame();
        String frame = frameUp.createTheUpperGameFrameStart();
        Assert.assertEquals("##################################### CodeKnacker #####################################",frame);
    }

    @Test
    public void creationUpperFrameEnd() throws StatusException, IOException {
        ICodeKnackerDrawFrame frameUp = this.objectFrame();
        String frame = frameUp.createTheUpperGameFrameEnd();
        Assert.assertEquals("############################### CodeKnacker - Spielende ###############################",frame);
    }

    @Test
    public void creationUpperFrameDown() throws StatusException, IOException {
        ICodeKnackerDrawFrame frameUp = this.objectFrame();
        //String frame = frameUp.createTheDownGameFrameEnd();
        //Assert.assertEquals("#######################################################################################",frame);
    }
}

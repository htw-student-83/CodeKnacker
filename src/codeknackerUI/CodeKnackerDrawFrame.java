package codeknackerUI;

import java.io.IOException;

public class CodeKnackerDrawFrame implements ICodeKnackerDrawFrame {

    @Override
    public String createTheUpperGameFrameStart(){
        return "##################################### CodeKnacker #####################################";
    }

    @Override
    public String createTheUpperGameFrameEnd()throws IOException {
        return "############################### CodeKnacker - Spielende ###############################";
    }

    @Override
    public String createTheDownGameFrameEnd() throws IOException {
        return null;
    }

    @Override
    public String createTheUpperGameFrameContinue() {
        return "##################################### CodeKnacker #####################################";
    }

    @Override
    public String createANUnderlineForPlayerName() {
        return "";
    }
}

package codeknackerUI;

import java.io.IOException;

public class CodeKnackerDrawFrame implements ICodeKnackerDrawFrame {

    @Override
    public String createTheUpperGameFrameStart(){
        return "################################################### CodeKnacker - Start ###################################################";
    }

    @Override
    public String createTheUpperGameFrameStart(int playerNumber) {
        return null;
    }

    @Override
    public String createTheUpperGameFrameEnd()throws IOException {
        String frameEnd = "################################### CodeKnacker - Spielende ###################################";
        return "################################################### CodeKnacker - Spielende ###############################################";
    }

    @Override
    public String createTheUpperGameFrameContinue() {
        return "###################################################### CodeKnacker ########################################################";
    }

    @Override
    public String createANUnderlineForPlayerName() {
        return "";
    }
}

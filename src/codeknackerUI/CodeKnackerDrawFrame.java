package codeknackerUI;

import codeknacker.ICodeKnackerDrawFrame;
import codeknacker.StatusException;

import java.io.IOException;

public class CodeKnackerDrawFrame implements ICodeKnackerDrawFrame {

    @Override
    public String createTheUpperGameFrameStart() throws StatusException {
        return "";
    }

    @Override
    public String createTheUpperGameFrameEnd() throws IOException {
        return "";
    }

    @Override
    public String createTheDownGameFrameEnd() throws IOException {
        return "";
    }

    @Override
    public String createANUnderlineForPlayerName() throws StatusException {
        return "";
    }
}

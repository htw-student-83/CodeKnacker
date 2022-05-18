package codeknacker;

import java.io.IOException;

public class CodeKnackerCallback implements ICodeKnackerCallback {

    private ICodeKnackerRandomNumbers object() {
        return new CodeKnackerRandomNumber();
    }

    @Override
    public void notity(int hintNumber) throws IOException {

        ICodeKnackerRandomNumbers randomNumber = this.object();

        if(hintNumber<randomNumber.getFinalElement(hintNumber)){
            System.out.println("Deine Eingabe ist zu klein.");
        }

        if(hintNumber>randomNumber.getFinalElement(hintNumber)){
            System.out.println("Deine Eingabe ist zu groß.");
        }

        if(hintNumber==randomNumber.getFinalElement(hintNumber)){
            System.out.println("Super, du hat eine richtige Zahl gefunden.");
        }
    }
}

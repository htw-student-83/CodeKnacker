package codeknacker;

import java.io.*;

public class CodeKnackerStream implements ICodeKnackerStreamsTheResult {
    private final String filename = "gameresult";

    @Override
    public String restoreGameResult() throws IOException {
        InputStream is = null;
        try {
            is = new FileInputStream(filename);
        }catch (FileNotFoundException e){
            System.err.println("File can't be opened right now." + e.getMessage());
            System.exit(0);
        }
        DataInputStream dais = new DataInputStream(is);
        try {
            String result = dais.readUTF();
            return result;
        }catch (IOException ex) {
            System.err.println("Something was wrong." + ex.getMessage());
            System.exit(0);
        }
        dais.close();
        return "-1";
    }

    @Override
    public void saveGameResult(String gameResult) throws IOException {
        OutputStream os = null;
        try {
            os = new FileOutputStream(filename);
        }catch (FileNotFoundException e){
            System.err.println("File can't be opened right now." + e.getMessage());
            System.exit(0);
        }

        DataOutputStream dos = new DataOutputStream(os);
        try {
            dos.writeUTF(gameResult);
        }catch (IOException ex){
            System.err.println("Nothing couldn't write into the file." + ex.getMessage());
            System.exit(0);
        }
        dos.close();
    }
}

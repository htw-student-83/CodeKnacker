package codeknacker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CodeKnackerStream implements ICodeKnackerStreamsTheResult {

    @Override
    public String restoreGameResult() throws IOException {
        InputStream is = Files.newInputStream(Paths.get("gameresult.txt"));
        String result = "";
        /*
        try {
            is =
        }catch (FileNotFoundException e){
            System.err.println("File can't be opened right now." + e.getMessage());
            System.exit(0);
        }

         */
        try (DataInputStream dais = new DataInputStream(is)) {
            result = dais.readUTF();
        } catch (IOException ex) {
            System.err.println("Something was wrong." + ex.getMessage());
            System.exit(0);
        }
        return result;
    }

    @Override
    public void saveGameResult(String gameResult) throws IOException {
        OutputStream os = Files.newOutputStream(Paths.get("gameresult.txt"));

        /*
        try {
            os =
        }catch (FileNotFoundException e){
            System.err.println("File can't be opened right now." + e.getMessage());
            System.exit(0);
        }
         */

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

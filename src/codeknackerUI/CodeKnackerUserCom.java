package codeknackerUI;

import codeknacker.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CodeKnackerUserCom implements ICodeKnackerUserCommunication {
    private static int numberOfInputs = 1;
    private final static int maxOfNumberOfInputs = 3;

    CodeKnackerPlayerStatus status = new CodeKnackerPlayerStatus();
    CodeKnackerRandomNumber code = new CodeKnackerRandomNumber();

    @Override
    public void deliveryHint(String playerName, int hint) throws IllegalArgumentException {

    }

    @Override
    public void yourHint() throws Exception, NetworkException {
        //status.setStatus(CodeKnackerStatus.PLAYER_1);
        //if(this.numberOfInputs == 0){
            //Methode in eine andere Klasse verlangern!
        //}
        boolean userIsReady = howIsYourNumberTip();
        if(userIsReady){
            CodeKnackerImpl impl = new CodeKnackerImpl();
            Scanner inputUser = new Scanner(System.in);
            //User gibt eine Kommazahl ein
            if(!inputUser.hasNextInt()){
                throw new GameException("Du hast eine Kommazahl eingegeben.");
            //User gibt eine negative Zahl ein
            }

            String inputUserString = inputUser.next();
            int userHintNumber = Integer.parseInt(inputUserString);

            if(userHintNumber<0){
                throw new GameException("Du hast eine negative Zahl eingegeben.");
            //User gibt Zahl außerhalb des Wertebereiches an
            }

            if(userHintNumber>9){
                throw new GameException("Deine Zahl liegt nicht im Intervall.");
            //API wird aufgerufen
            }else{
                impl.checkHintNumber(userHintNumber, 1);
            }
        }else{
            //Spielende
            //TODO
        }

        /*
        if(ui.getStatus() == CodeKnackerStatus.PLAYER_1){
            System.out.println("How does your next hint number Player1?");
            //Hier kommt noch die UserEingabenverarbeitung hin
            incrementNumberOfInputs();
           impl.checkHintNumber(number, 2);
        }else{
            System.out.println("How does your next hint number Player2?");
            //Hier kommt noch die UserEingabenverarbeitung hin
            incrementNumberOfInputs();
            impl.checkHintNumber(number, 2);
        }
         */
    }


    /*
    public String yourHint2() throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    */

    public static void incrementNumberOfInputs(){
        numberOfInputs++;
    }

    @Override
    public boolean howIsYourNumberTip() throws Exception, NetworkException {
        if(numberOfInputs<=maxOfNumberOfInputs){
            return true;
        }else{
            //status.setStatus(CodeKnackerStatus.ENDED);
            createTheUpperPartOfTheGameFrameEnd();
            return false;
        }
    }


    @Override
    public void askForAsecondRound() throws Exception, NetworkException {
        CodeKnackerImpl impl = new CodeKnackerImpl();
        CodeKnackerPunkte punkte = new CodeKnackerPunkte();
        System.out.println("Do you want to start a new round?");
        System.out.println("(j)");
        System.out.println("(n)");
        Scanner inputUser = new Scanner(System.in);
        String input = inputUser.next();
        if(!(inputUser.next().equals("j") || inputUser.next().equals("n"))){
            System.err.println("Du hast ein ungültiges Zeichen eingegeben.");
            askForAsecondRound();
        }else if(input.equals("j")){
            numberOfInputs = 1;
            punkte.setPunktePlayer1Zero();
            //Methode in die UserCom-Klasse verlagern!
            code.createThreeUniqueRandomNumbers();
            for(int i = 0; i< CodeKnackerRandomNumber.code.length; i++){
                System.out.print(CodeKnackerRandomNumber.code[i]);
            }
            System.out.println();
            impl.setI();
            createTheUpperPartOfTheGameFrameContinue();
        }else{
            doExit();
        }
    }

    public void createTheUpperPartOfTheGameFrameStart() throws Exception, NetworkException {
        CodeKnackerUserCom com = new CodeKnackerUserCom();
        String upperPartOfTheGameFrame = "##################################### CodeKnacker #####################################";
        System.out.println("##################################### CodeKnacker #####################################");
        getStoryOfGame();
        System.out.println("Aktuller Index: " + CodeKnackerImpl.index);
        String spieler = "Spieler1 ist dran.";
        System.out.println();
        int laengeSpielername  = spieler.length();
        //int laenge  = upperPartOfTheGameFrame.length();
        //System.out.print(upperPartOfTheGameFrame);
        System.out.print(spieler);
        createUnderline(laengeSpielername);
        System.out.println();
        System.out.print("Dein " + CodeKnackerUserCom.numberOfInputs + ". Tipp für die gesuchte Zahl lautet?");
        System.out.println();
        yourHint();
    }

    public void createTheUpperPartOfTheGameFrameContinue() throws Exception, NetworkException {
        String upperPartOfTheGameFrame = "##################################### CodeKnacker #####################################";
        System.out.println("##################################### CodeKnacker #####################################");
        String spieler = "Spieler1 ist dran.";
        System.out.println();
        int laengeSpielername  = spieler.length();
        //int laenge  = upperPartOfTheGameFrame.length();
        //System.out.print(upperPartOfTheGameFrame);
        System.out.print(spieler);
        createUnderline(laengeSpielername);
        System.out.println();
        System.out.print("Dein " + CodeKnackerUserCom.numberOfInputs + ". Tipp für die gesuchte Zahl lautet?");
        System.out.println();
        yourHint();
    }

    public void createTheUpperPartOfTheGameFrame() throws Exception, NetworkException {
        String upperPartOfTheGameFrame = "##################################### CodeKnacker #####################################";
        System.out.println("##################################### CodeKnacker #####################################");
        System.out.println("Aktuller Index: " + CodeKnackerImpl.index);
        String spieler = "Spieler1 ist dran.";
        int laengeSpielername  = spieler.length();
        //int laenge  = upperPartOfTheGameFrame.length();
        //System.out.print(upperPartOfTheGameFrame);
        System.out.print(spieler);
        createUnderline(laengeSpielername);
        System.out.println();
        System.out.print("Dein " + CodeKnackerUserCom.numberOfInputs + ". Tipp für die gesuchte Zahl lautet?");
        System.out.println();
        yourHint();
    }

    public void getStoryOfGame(){
        System.out.println("Vorgeschichte:");
        System.out.println("Vor Jahren hat sich Alice einen Safe zugelegt, um ihre Wertsachen in Sicherheit zu wissen.");
        System.out.println("Leider hat sie ihren Code vergessen-(");
        System.out.println("Damit der Code nicht in falsche Hände gerät, überlegte sich Alice einst sich diese Zahlenkombination nicht zu notieren *oh*.");
        System.out.println("Da sie im Raten von Zahlen auch nicht besonders erfolgreich ist, braucht sie dringend eure Hilfe.");
    }

    public void createUnderline(int lSpielername) {
        System.out.println();
        for (int i = 0; i < lSpielername; i++) {
            System.out.print("`");
        }
    }

    public void doExit() throws IOException {
        System.exit(0);
        // shutdown engines which needs to be
        //this.protocolEngine.close();
    }

    public void createTheUpperPartOfTheGameFrameEnd() throws Exception, NetworkException {
        CodeKnackerPunkte punkte = new CodeKnackerPunkte();
        String upperPartOfTheGameFrameEnd = "############################### CodeKnacker - Spielende ###############################";
        int laenge = upperPartOfTheGameFrameEnd.length();
        System.out.println(upperPartOfTheGameFrameEnd);
        System.out.println();
        System.out.print("Der gesuchte Zahlencode lautet: " + Arrays.toString(CodeKnackerRandomNumber.code));
        System.out.println();
        System.out.println("Du hast folgende Punktezahl erreicht: " + punkte.getPunktePlayer1());
        //System.out.print("Gewonnen/Verloren hat: Spieler1/ Spieler2");
        System.out.println();
        createTheDownPartOfTheGameFrame(laenge);
        System.out.println();
        askForAsecondRound();
    }

    public static void createTheDownPartOfTheGameFrame(int zeichenlaenge) {
        //funktionen(
        //Hier werden die Ergebnisse durch weitere Funktionen dargestellt
        //1. Die gesuchte Zahlenkombination in der Form Zahlencode: [x, y, z]
        //2. Sieger/Verlierer/ Unentschieden
        //   - Sieger in Form -> Gewonnen hat: Spielername1/Spielername2
        //   - Verloren in Form -> Verloren hat: Spielername2/Spielername1
        //   - Das Spiel ist unentschieden ausgegangen
        // );
        for (int i = 0; i<zeichenlaenge; i++){
          System.out.print("#");
        }
    }
}

package codeknackerUI;

import codeknacker.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CodeKnackerUserCom implements ICodeKnackerUserCommunication {
    private static int numberOfInputs = 1;
    private final static int maxOfNumberOfInputs = 3;
    //private final String localPlayerName;

    //Fehlerbehandlung für den Start überarbeiten!

    CodeKnackerPlayerStatus status = new CodeKnackerPlayerStatus();
    CodeKnackerRandomNumber code = new CodeKnackerRandomNumber();
    CodeKnackerDrawFrame frame = new CodeKnackerDrawFrame();
    CodeKnackerPunkte punkte = new CodeKnackerPunkte();


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
            if (!inputUser.hasNextDouble()){
                throw new GameException("Your input is invalid.");
            }

            //User gibt eine Kommazahl ein
            if(!inputUser.hasNextInt()){
                throw new DoubleNumberException("Your input wasn't a positive number.");
            }

            String inputUserString = inputUser.next();
            int userHintNumber = Integer.parseInt(inputUserString);

            //User gibt Zahl außerhalb des Wertebereiches an
            if(userHintNumber<0 || userHintNumber>9){
                throw new GameException("Your input number is outside the intervall.");
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

    public static void setNumberOfInputsToOne(){
        numberOfInputs = 1;
    }

    public static void incrementNumberOfInputs(){
        numberOfInputs++;
    }

    public static int getNumberOfInputs(){
        return numberOfInputs;
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
        if(!input.equals("j") && !input.equals("n")){
            System.err.println("Your input is invalid.");
            askForAsecondRound();
        }else if(input.equals("j")){
            numberOfInputs = 1;
            punkte.setPunktePlayer1Zero();
            code.createThreeUniqueRandomNumbers();
            System.out.println();
            impl.setI();
            //chooseTheFirstPlayer();
            createTheUpperPartOfTheGameFrameContinue();
        }else{
            doExit();
        }
    }

    public void createTheUpperPartOfTheGameFrameStart() throws Exception, NetworkException {
        CodeKnackerDrawFrame frame = new CodeKnackerDrawFrame();
        System.out.println(frame.createTheUpperGameFrameStart());
        getStoryOfGame();
        //Hier muss bestimmt werden, welcher Spieler zuerst an der Reihe ist
        //chooseTheFristPlayer()
        String spieler = "Spieler1 ist dran.";
        System.out.println();
        int laengeSpielername  = spieler.length();
        System.out.print(spieler);
        createUnderline(laengeSpielername);
        System.out.println();
        CodeKnackerUserCom.userRequest();
        System.out.println();
        //Prüfen, ob diese Variante sinnvoll ist!
        try {
            yourHint();
        }catch (DoubleNumberException | NegativNumberException | GameException e){
            System.err.println(e.getLocalizedMessage());
            CodeKnackerUserCom.userRequest();
            yourHint();
        }
    }

    public void createTheUpperPartOfTheGameFrameContinue() throws Exception, NetworkException {
        System.out.println(frame.createTheUpperGameFrameContinue());
        //Hier muss bestimmt werden, welcher Spieler zuerst an der Reihe ist
        //chooseTheFristPlayer()
        String spieler = "Spieler1 ist dran.";
        System.out.println();
        int laengeSpielername  = spieler.length();
        System.out.print(spieler);
        createUnderline(laengeSpielername);
        code.createThreeUniqueRandomNumbers();
        for(int i = 0; i<CodeKnackerRandomNumber.code.length; i++){
            System.out.print(code.getElement(i));
        }
        System.out.println();
        CodeKnackerUserCom.userRequest();
        System.out.println();
        try {
            yourHint();
        }catch (DoubleNumberException | NegativNumberException | GameException e){
            System.err.println(e);
            CodeKnackerUserCom.userRequest();
            yourHint();
        }
    }

    public void createTheUpperPartOfTheGameFrame() throws Exception, NetworkException {
        System.out.println(frame.createTheUpperGameFrameContinue());
        System.out.println();
        //Hier muss eine Incrementierung/Decrementierung stattfinden und ein
        //Wechsel des Zustandes
        String spieler = "Spieler1 ist dran.";
        int laengeSpielername  = spieler.length();
        System.out.print(spieler);
        createUnderline(laengeSpielername);
        System.out.println();
        CodeKnackerUserCom.userRequest();
        System.out.println();
        try {
            yourHint();
        }catch (DoubleNumberException | NegativNumberException | GameException e){
            System.err.println(e);
            CodeKnackerUserCom.userRequest();
            yourHint();
        }
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

    public static void userRequest(){
        System.out.println("Your " + CodeKnackerUserCom.numberOfInputs +
                ". hint for the following number at index " + CodeKnackerImpl.index + " is?");
    }

    public void createTheUpperPartOfTheGameFrameEnd() throws Exception, NetworkException {
        //Der Zustand beider Spieler ist im Endzustand
        //Es findet dann der Punktevergleich statt
        System.out.println(frame.createTheUpperGameFrameEnd());
        System.out.println();
        System.out.print("The right code is: " + Arrays.toString(CodeKnackerRandomNumber.code));
        System.out.println();
        System.out.println("Du hast folgende Punktezahl erreicht: " + punkte.getPunktePlayer1());
        //Ab hier wird der Gewinner/ das Unentschieden in die file gespeichert werden
        //System.out.print("Gewonnen hat: Spieler1/ Spieler2");
        System.out.println();
        String frameEnd = frame.createTheUpperGameFrameEnd();
        int lengthOfFrameEnd = frameEnd.length();
        createTheDownPartOfTheGameFrame(lengthOfFrameEnd);
        System.out.println();
        askForAsecondRound();
    }

    public static void createTheDownPartOfTheGameFrame(int lFrame) throws IOException {
        for (int i = 0; i<lFrame; i++){
          System.out.print("#");
        }
    }

    //funktionen(
    //Hier werden die Ergebnisse durch weitere Funktionen dargestellt
    //1. Die gesuchte Zahlenkombination in der Form Zahlencode: [x, y, z]
    //2. Sieger/ Unentschieden
    //   - Sieger in Form -> Gewonnen hat: Spielername1/Spielername2
    //   - Unentschieden in Form -> Gewonnen hat: niemand
    // );
}

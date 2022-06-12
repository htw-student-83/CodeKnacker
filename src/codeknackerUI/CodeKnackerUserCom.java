package codeknackerUI;

import codeknacker.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CodeKnackerUserCom implements ICodeKnackerUserCommunication {
    private static int numberOfInputsPlayer1 = 1;
    private static int numberOfInputsPlayer2 = 1;
    private static int numberOfInputs = 0;
    private final static int maxOfNumberOfInputs = 3;
    private final static int theSmallestValidRandomNumber = 0;
    private final static int theBiggestValidRandomNumber = 9;
    //private final String localPlayerName;
    CodeKnackerRandomNumber code = new CodeKnackerRandomNumber();
    CodeKnackerDrawFrame frame = new CodeKnackerDrawFrame();
    CodeKnackerPunkte punkte = new CodeKnackerPunkte();

    @Override
    public void yourHint() throws Exception, NetworkException{
        CodeKnackerImpl impl = new CodeKnackerImpl();
        boolean userIsReady = howIsYourNumberTip();
        if(userIsReady) {
            Scanner inputUser = new Scanner(System.in);
            if (!inputUser.hasNextDouble()){
                throw new GameException("Your input is invalid.");
            }

            if (!inputUser.hasNextInt()){
                throw new GameException("Your input was not a positive number incl. zero.");
            }

            String inputUserString = inputUser.next();
            int userHintNumber = Integer.parseInt(inputUserString);
            //User gibt Zahl außerhalb des Wertebereiches an
            if(userHintNumber < CodeKnackerUserCom.theSmallestValidRandomNumber ||
                    userHintNumber > CodeKnackerUserCom.theBiggestValidRandomNumber){
                throw new GameException("Your input number is outside the intervall.");
            }else{
                impl.checkHintNumber(userHintNumber);
            }
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
    public void yourHintTesting() throws Exception, NetworkException {
        //CodeKnackerImpl impl = new CodeKnackerImpl();
        Scanner inputUser = new Scanner(System.in);
        if (!inputUser.hasNextDouble()){
            throw new GameException("Your input is invalid.");
        }

        if (!inputUser.hasNextInt()){
            throw new GameException("Your input was not a positive number incl. zero.");
        }

        String inputUserString = inputUser.next();
        int userHintNumber = Integer.parseInt(inputUserString);

        //User gibt Zahl außerhalb des Wertebereiches an
        if(userHintNumber < CodeKnackerUserCom.theSmallestValidRandomNumber ||
                userHintNumber > CodeKnackerUserCom.theBiggestValidRandomNumber){
            throw new GameException("Your input number is outside the intervall.");
        }else{
            impl.checkHintNumberForTesting(userHintNumber, playernumber);
            incrementPlayernumber();
        }
    }
     */

    public static void setNumberOfInputsToOne(){
        numberOfInputs = 1;
    }

    public static void incrementNumberOfInputs() {
        numberOfInputs++;
    }

    public static void setNumberOfInputsToOne_Player1(){
        numberOfInputsPlayer1 = 1;
    }

    public static void setNumberOfInputsToOne_Player2(){
        numberOfInputsPlayer2 = 1;
    }

    public static void incrementNumberOfInputs_Player1(){
        numberOfInputsPlayer1++;
    }

    public static void incrementNumberOfInputs_Player2(){
        numberOfInputsPlayer2++;
    }

    public static int getNumberOfInputs_player1(){
        return numberOfInputsPlayer1;
    }

    public static int getNumberOfInputs_player2(){
        return numberOfInputsPlayer2;
    }

    public static int getNumberOfInputs(){
        return numberOfInputs;
    }

    public static int getMaxOfNumberOfInputs() {
        return maxOfNumberOfInputs;
    }

    @Override
    public boolean howIsYourNumberTip() throws Exception, NetworkException {
        if(numberOfInputsPlayer1<=maxOfNumberOfInputs){
            return true;
        }else if(numberOfInputsPlayer2<=maxOfNumberOfInputs){
            return true;
        }else{
            createTheUpperPartOfTheGameFrameEnd();
            return false;
        }
    }

    /**
     * to choose the first player of the game
     * @return the playernumber
     */
    public int  chooseTheFirstPlayer(){
        int firstPlayerNumber = 1;
        int secondPlayerNumber = 2;
        int randomNumber = (int) Math.floor(Math.random()*(secondPlayerNumber-firstPlayerNumber+1)
                +firstPlayerNumber);
        return randomNumber;
    }



    public void createTheUpperPartOfTheGameFrameStart(int playernumber) throws Exception, NetworkException {
        CodeKnackerDrawFrame frame = new CodeKnackerDrawFrame();
        System.out.println(frame.createTheUpperGameFrameStart());
        getStoryOfGame();
        if(playernumber == 1){
            ChangeStatus.setStatus(CodeKnackerStatus.PLAYER1_ACTIVE);
            //Don't repeat yourself!!!
            String spieler = "Spieler1 ist dran.";
            System.out.println();
            int laengeSpielername  = spieler.length();
            System.out.print(spieler);
            createUnderline(laengeSpielername);
            System.out.println();
            CodeKnackerUserCom.userRequest();
            System.out.println();
            try {
                yourHint();
            }catch (DoubleNumberException | NegativNumberException | GameException e){
                System.err.println(e.getLocalizedMessage());
                CodeKnackerUserCom.userRequest();
                yourHint();
            }
        }
        if(playernumber == 2){
            ChangeStatus.setStatus(CodeKnackerStatus.PLAYER2_ACTIVE);
            String spieler = "Spieler2 ist dran.";
            System.out.println();
            int laengeSpielername  = spieler.length();
            System.out.print(spieler);
            createUnderline(laengeSpielername);
            System.out.println();
            CodeKnackerUserCom.userRequest();
            System.out.println();
            try {
                yourHint();
            }catch (DoubleNumberException | NegativNumberException | GameException e){
                System.err.println(e.getLocalizedMessage());
                CodeKnackerUserCom.userRequest();
                yourHint();
            }
        }
    }


    public void createTheUpperPartOfTheGameFrameContinue() throws Exception, NetworkException {
        System.out.println(frame.createTheUpperGameFrameStart());
        if(ChangeStatus.getStatus()==CodeKnackerStatus.PLAYER1_ACTIVE){
            String spieler = "Spieler1 ist dran.";
            System.out.println();
            int laengeSpielername  = spieler.length();
            System.out.print(spieler);
            createUnderline(laengeSpielername);
            System.out.println();
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
        if(ChangeStatus.getStatus()==CodeKnackerStatus.PLAYER2_ACTIVE){
            String spieler = "Spieler2 ist dran.";
            System.out.println();
            int laengeSpielername  = spieler.length();
            System.out.print(spieler);
            createUnderline(laengeSpielername);
            code.createThreeUniqueRandomNumbers();
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
    }


    public void createTheUpperPartOfTheGameFrame() throws Exception, NetworkException {
        System.out.println(frame.createTheUpperGameFrameContinue());
        System.out.println();
        //Don't repeat yourself!!!
        if(ChangeStatus.getStatus() == CodeKnackerStatus.PLAYER1_ACTIVE){
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
        if(ChangeStatus.getStatus() == CodeKnackerStatus.PLAYER2_ACTIVE){
            String spieler = "Spieler2 ist dran.";
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
    }

    public void getStoryOfGame(){
        System.out.println("Vorgeschichte:");
        System.out.println("Vor Jahren hat sich Alice einen Safe zugelegt, um ihre Wertsachen in Sicherheit zu wissen.");
        System.out.println("Leider hat sie ihren Code vergessen-(");
        System.out.println("Damit der Code nicht in falsche Hände gerät, hat sich Alice diesen code auch nicht notiert *oh*.");
        System.out.println("Da sie im Raten von Zahlen auch nicht besonders gut ist, braucht sie dringend Hilfe.");
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
        if(ChangeStatus.getStatus() == CodeKnackerStatus.PLAYER1_ACTIVE){
            System.out.println("Your " + CodeKnackerUserCom.numberOfInputsPlayer1 +
                    ". hint for the following number at index " + CodeKnackerImpl.index + " is?");
        }else {
            System.out.println("Your " + CodeKnackerUserCom.numberOfInputsPlayer2 +
                    ". hint for the following number at index " + CodeKnackerImpl.index + " is?");
        }
    }

    public void createTheUpperPartOfTheGameFrameEnd() throws Exception, NetworkException {
        CodeKnackerImpl result = new CodeKnackerImpl();
        String winner = result.won();
        System.out.println(frame.createTheUpperGameFrameEnd());
        System.out.println();
        System.out.print("The right code is: " + Arrays.toString(CodeKnackerRandomNumber.code));
        System.out.println();
        System.out.println("The winner is: " + winner);
        System.out.println();
        String frameEnd = frame.createTheUpperGameFrameEnd();
        int lengthOfFrameEnd = frameEnd.length();
        createTheDownPartOfTheGameFrame(lengthOfFrameEnd);
        System.out.println();
        askForAsecondRound();
    }

    public void createTheUpperPartOfTheGameFrameEndForTesting() throws Exception {
        CodeKnackerImpl result = new CodeKnackerImpl();
        result.won();
    }

    public static void createTheDownPartOfTheGameFrame(int lFrame) {
        for (int i = 0; i<lFrame; i++){
          System.out.print("#");
        }
    }

    public void setAllValuesToInitial(){
        setNumberOfInputsToOne_Player1();
        setNumberOfInputsToOne_Player2();
        punkte.setPunktePlayer1Zero();
        punkte.setPunktePlayer2Zero();
        CodeKnackerImpl.setI();
    }


    public void askForAsecondRound() throws Exception, NetworkException {
        CodeKnackerUserCom com = new CodeKnackerUserCom();
        System.out.println("Do you want to start a new round?");
        System.out.println("(j)");
        System.out.println("(n)");
        Scanner inputUser = new Scanner(System.in);
        String input = inputUser.next();
        if(!input.equals("j") && !input.equals("n")){
            System.err.println("Your input is invalid.");
            askForAsecondRound();
        }else if(input.equals("j")){
            com.setAllValuesToInitial();
            CodeKnackerRandomNumber randomcode = new CodeKnackerRandomNumber();
            randomcode.createThreeUniqueRandomNumbers();
            System.out.println();
            for(int i = 0; i<CodeKnackerRandomNumber.code.length; i++){
                System.out.print(randomcode.getElement(i));
            }
            if(ChangeStatus.getStatus()==CodeKnackerStatus.PLAYER1_ACTIVE){
                ChangeStatus.setStatus(CodeKnackerStatus.PLAYER2_ACTIVE);
                com.createTheUpperPartOfTheGameFrameContinue();
            }else{
                ChangeStatus.setStatus(CodeKnackerStatus.PLAYER1_ACTIVE);
                com.createTheUpperPartOfTheGameFrameContinue();
            }
        }else{
            com.doExit();
        }
    }
}

package codeknackerUI;

import codeknacker.CodeKnackerRandomNumber;
import codeknacker.GameException;
import codeknackerNetwork.CodeKnackerTCPProtocolEngine;
import codeknacker.CodeKnackerStream;
import codeknackerNetwork.TCPStream;
import java.io.*;

public class UICodeKnacker {
    CodeKnackerUserCom com = new CodeKnackerUserCom();
    CodeKnackerRandomNumber codeSolution = new CodeKnackerRandomNumber();
    private static final String CONNECT = "c";
    private static final String RulesOfTheGame = "r";
    private static final String START = "s";
    private static final String HISTORY = "h";
    private static final String EXIT = "e";
    private final PrintStream outStream;
    private final BufferedReader inBufferedReader;
    private final String playerName;
    //private final CodeKnackerImpl gameEngine;
    //private final TicTacToeLocalBoard localBord;
    private TCPStream tcpStream;
    private CodeKnackerTCPProtocolEngine protocolEngine;
    private String partnerName;

    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println("                              Welcome to the CodeKnacker");
        System.out.println("");
        if (args.length < 1) {
            System.err.println("need playerName as parameter");
            System.exit(1);
        }

        System.out.println("Hey " + args[0] + "-)");

        UICodeKnacker userCmd = new UICodeKnacker(args[0], System.out, System.in);

        userCmd.printUsage();
        userCmd.runCommandLoop();

        /*
        //to start the game, if two players are connected
        if(this.status==CodeKnackerStatus.CONNECTED) {
            //ComKlasse einfügen!
            CodeKnackerPlayerStatus status = new CodeKnackerPlayerStatus();
            status = CodeKnackerStatus.START;
            com.createTheUpperPartOfTheGameFrameStart();
        } else {
           throw new NetworkException("Unfortnetly the connection was failed.");
        }
         */
    }

    public UICodeKnacker(String playerName, PrintStream os, InputStream is) throws Exception {
        this.playerName = playerName;
        this.outStream = os;
        this.inBufferedReader = new BufferedReader(new InputStreamReader(is));

        //this.gameEngine = new TicTacToeImpl(playerName);
        //this.localBord = this.gameEngine;
        //this.localBord.subscribeChangeListener(this);
    }

    public void printUsage() {
        StringBuilder b = new StringBuilder();

        b.append("\n");
        b.append("Please choose one of the following points:");
        b.append("\n");
        b.append(RulesOfTheGame);
        b.append("...to get the game' rules");
        b.append("\n");
        b.append(CONNECT);
        b.append("...to get in contact with an other player");
        b.append("\n");
        b.append(START);
        b.append("...let's start the game");
        b.append("\n");
        b.append(HISTORY);
        b.append("...history of the last game result");
        b.append("\n");
        b.append(EXIT);
        b.append("...stop the program");
        b.append("\n");

        this.outStream.println(b.toString());
    }

    public void runCommandLoop() throws Exception {
        boolean again = true;

        while (again) {
            boolean rememberCommand = true;
            String cmdLineString = null;

            try {
                // read user input
                cmdLineString = inBufferedReader.readLine();

                // finish that loop if less than nothing came in
                if (cmdLineString == null) break;

                // trim whitespaces on both sides
                cmdLineString = cmdLineString.trim();

                // extract command
                int spaceIndex = cmdLineString.indexOf(' ');
                spaceIndex = spaceIndex != -1 ? spaceIndex : cmdLineString.length();

                // got command string
                String commandString = cmdLineString.substring(0, spaceIndex);

                // extract parameters string - can be empty
                String parameterString = cmdLineString.substring(spaceIndex);
                parameterString = parameterString.trim();

                // start command loop
                switch (commandString) {
                    case CONNECT:
                        this.doConnect(parameterString);
                        break;
                    case RulesOfTheGame:
                        this.getRules();
                        break;
                    case START:
                        try {
                            codeSolution.createThreeUniqueRandomNumbers();
                            for(int i = 0; i<CodeKnackerRandomNumber.code.length; i++){
                                System.out.print(codeSolution.getElement(i));
                            }
                            System.out.println();
                            int playerNumber = com.chooseTheFirstPlayer();
                            com.createTheUpperPartOfTheGameFrameStart(playerNumber);
                        }catch (GameException e){
                            e.printStackTrace();
                        }
                        break;
                    case HISTORY:
                        this.openHistory();
                        break;
                    case EXIT:
                        again = false;
                        com.doExit();
                        break; // end loop
                    default:
                        this.outStream.println("your commant is invalid:" + cmdLineString);
                        this.printUsage();
                        rememberCommand = false;
                        break;
                }
            } catch (IOException ex) {
                this.outStream.println("cannot read from input stream - fatal, give up");
                try {
                    com.doExit();
                } catch (IOException e) {
                    // ignore
                }
            } catch (RuntimeException ex) {
                this.outStream.println("runtime problems: " + ex.getLocalizedMessage());
            } catch (NetworkException e) {
                this.outStream.println("problems with the network: " + e.getLocalizedMessage());
            }
        }
    }

    private void getRules() throws Exception {
        System.out.println("//Rules:");
        System.out.println("//Allow are only positive numbers incl. zero at intervall [0;9]");
        System.out.println("//one point for a right input number");
        System.out.println("//if the input number is wrong the user will get a feedback");
        System.out.println("//after every input the next player is turn");
        System.out.println("//every player has 3 attempts to guess the right of three numbers");
        printUsage();
        runCommandLoop();
    }

    private void openHistory() throws Exception {
        String testString = "test123";
        CodeKnackerStream stream = new CodeKnackerStream();
        stream.saveGameResult(testString);
        System.out.println("Die letzte Rounde gewann: " + stream.restoreGameResult());
        printUsage();
        runCommandLoop();
    }

    private void doConnect(String parameterString) throws Exception {
        System.out.println("It's coming soon.");
        printUsage();
        runCommandLoop();
        /*if (this.alreadyConnected()) return;

        String hostname = null;


        try {
            StringTokenizer st = new StringTokenizer(parameterString);
            hostname = st.nextToken();
            this.status = CodeKnackerStatus.CONNECTED;
        }
        catch(NoSuchElementException e) {
            System.out.println("no hostname provided - take localhost");
            hostname = "localhost";
        }

        this.tcpStream = new TCPStream(TicTacToe.DEFAULT_PORT, false, this.playerName);
        this.tcpStream.setRemoteEngine(hostname);
        this.tcpStream.setStreamCreationListener(this);
        this.tcpStream.start();
         */
    }
}

package codeknackerUI;

import codeknacker.CodeKnackerTCPProtocolEngine;
import codeknacker.TCPStream;
import java.io.*;

public class UICodeKnacker {
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

        //to start the game when the rule is succuesful
        if (true) {
            //Wenn 2 Spieler feststehen
            //createTheUpperPartOfTheGameFrame();
        } else {
            //when something is failed
        }
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
        b.append("...to get the rules of the game");
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

    public void runCommandLoop() {
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
                        this.createTheUpperPartOfTheGameFrame();
                        break;
                    case HISTORY:
                        //this.doSet(parameterString);
                        this.openHistory();
                        break;
                    case EXIT:
                        again = false;
                        this.doExit();
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
                    this.doExit();
                } catch (IOException e) {
                    // ignore
                }
            } catch (RuntimeException ex) {
                this.outStream.println("runtime problems: " + ex.getLocalizedMessage());
            }
        }
    }

    private void getRules() {
        System.out.println("//Rules:");
        System.out.println("//Allow are only numbers at intervall [0;9]");
        System.out.println("//two points for a right input number");
        System.out.println("//if the input number is wrong the user will get a feedback");
        System.out.println("//after every input the next player is turn");
        System.out.println("//every player has 2-3attempts to guess the right of three numbers");
        printUsage();
        runCommandLoop();
    }

    private void doExit() throws IOException {
        System.exit(0);
        // shutdown engines which needs to be
        //this.protocolEngine.close();
    }

    private void openHistory() {
        //Mit Streams die Daten aus einer txt-Datei auslesen
        System.out.println("It's coming soon.");
        printUsage();
        runCommandLoop();
    }

    private void doConnect(String parameterString) {
        System.out.println("It's coming soon.");
        printUsage();
        runCommandLoop();
        /*if (this.alreadyConnected()) return;

        String hostname = null;

        try {
            StringTokenizer st = new StringTokenizer(parameterString);
            hostname = st.nextToken();
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


    public void createTheUpperPartOfTheGameFrame() {
        String upperPartOfTheGameFrame = "##################################### CodeKnacker #####################################";
        System.out.println("##################################### CodeKnacker #####################################");
        System.out.println("Vorgeschichte:");
        System.out.println("Vor Jahren hat sich Alice einen Safe zugelegt, um ihre Wertsachen in Sicherheit zu wissen.");
        System.out.println("Leider hat sie ihren Code vergessen-(");
        System.out.println("Damit der Code nicht in falsche Hände gerät, überlegte sich Alice einst sich diese Zahlenkombination nicht zu notieren *oh*.");
        System.out.println("Da sie im Raten von Zahlen auch nicht besonders erfolgreich ist, braucht sie dringend eure Hilfe.");
        printUsage();
        runCommandLoop();
        /*
        String spieler = "Spieler1 ist dran.";
        int laengeSpielername  = spieler.length();
        int laenge  = upperPartOfTheGameFrame.length();
        System.out.print(upperPartOfTheGameFrame);
        System.out.println();
        System.out.println();
        System.out.print("Spieler1 ist dran.");
        createUnderline(laengeSpielername);
        System.out.println();
        System.out.print("Dein Tipp für die 1. Zahl lautet?");
        System.out.println();

        System.out.print("1. Tipp: -Usereingabe-");
        System.out.println();
        System.out.println();
         */
    }
}

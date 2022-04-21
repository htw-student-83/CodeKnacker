package codeknackerUI;

import codeknacker.CodeKnackerTCPProtocolEngine;
import codeknacker.TCPStream;
import java.io.*;

public class UICodeKnacker {
    private static final String CONNECT = "a";
    private static final String START = "b";
    private static final String HISTORY = "c";
    private static final String EXIT = "d";
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
        b.append(CONNECT);
        b.append("..to get in contact with an other player");
        b.append("\n");
        b.append(START);
        b.append("..let's start the game");
        b.append("\n");
        b.append(HISTORY);
        b.append("..history of the last winner");
        b.append("\n");
        b.append(EXIT);
        b.append("..stop the program");
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

    private void doExit() throws IOException {
        System.out.println("It's caming soon.");
        printUsage();
        runCommandLoop();
        // shutdown engines which needs to be
        //this.protocolEngine.close();
    }

    private void openHistory(){
        System.out.println("It's caming soon.");
        printUsage();
        runCommandLoop();
    }

    private void doConnect(String parameterString) {
        System.out.println("It's caming soon.");
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


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                                                                          //
    //                                     Ab hier nicht mehr Teil der UI                                       //
    //                                                                                                          //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void createUnderline(int lSpielername) {
        System.out.println();
        for (int i = 0; i < lSpielername; i++) {
            System.out.print("`");
        }
    }

    public void createTheUpperPartOfTheGameFrame(){
        System.out.println("It's caming soon.");
        printUsage();
        runCommandLoop();
        String upperPartOfTheGameFrame = "##################################### CodeKnacker #####################################";
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

    public static void createTheUpperPartOfTheGameFrameEnd() {
        String upperPartOfTheGameFrameEnd = "############################### CodeKnacker - Spielende ###############################";
        int laenge = upperPartOfTheGameFrameEnd.length();
        System.out.print(upperPartOfTheGameFrameEnd);
        System.out.println();
        System.out.println();
        System.out.print("Der gesuchte Zahlencode lautet: [X, Y, Z]");
        System.out.println();
        System.out.print("Das Spiel ist unentschieden ausgegangen.");
        //System.out.print("Gewonnen/Verloren hat: Spieler1/ Spieler2");
        System.out.println();
        System.out.println();
        //createTheDownPartOfTheGameFrame(laenge);
    }

    //public static void createTheDownPartOfTheGameFrame(int zeichenlaenge) {

        //funktionen(
                //Hier werden die Ergebnisse durch weitere Funktionen dargestellt
                //1. Die gesuchte Zahlenkombination in der Form Zahlencode: [x, y, z]
                //2. Sieger/Verlierer/ Unentschieden
                //   - Sieger in Form -> Gewonnen hat: Spielername1/Spielername2
                //   - Verloren in Form -> Verloren hat: Spielername2/Spielername1
                //   - Das Spiel ist unentschieden ausgegangen
       // );

        //for (int i = 0; i<zeichenlaenge; i++){
          //  System.out.print("#");
        //}
    //
}

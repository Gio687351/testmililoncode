package refactula.design.patterns.behavioral.command.mu_puzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MuPuzzleApp {
    private static final Pattern III_TO_U_PATTERN = Pattern.compile("iii ([0-9]{0,3})", Pattern.CASE_INSENSITIVE);
    private static final Pattern REMOVE_UU_PATTERN = Pattern.compile("uu ([0-9]{0,3})", Pattern.CASE_INSENSITIVE);

    private final MuPuzzleGame game;
    private final PrintWriter writer;
    private final BufferedReader reader;

    public static void main(String[] args) {
        MuPuzzleApp app = new MuPuzzleApp(
                new MuPuzzleGame(),
                new PrintWriter(System.out),
                new BufferedReader(new InputStreamReader(System.in)));

        app.play();
    }

    public MuPuzzleApp(MuPuzzleGame game, PrintWriter writer, BufferedReader reader) {
        this.game = game;
        this.writer = writer;
        this.reader = reader;
    }

    public void play() {
        while (!game.isSolved()) {
            String action = askForAction();
            perform(action);
        }
        writer.println();
        writer.println("Congratulations! You have solved the puzzle!");
        writer.flush();
    }

    private String askForAction() {
        writer.println();
        writer.println("Current game state: " + game.toString());
        writer.println("Please specify your next command (type \"help\" for more info)");
        writer.println();
        writer.print("> ");
        writer.flush();
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void perform(String action) {
        Matcher m;

        if (action.equalsIgnoreCase("help")) {
            writer.println();
            writer.println("Available commands:");
            writer.println("\tadd u");
            writer.println("\t\tAdd a U to the end of any string ending in I");
            writer.println("\tdouble");
            writer.println("\t\tDouble the string after the M");
            writer.println("\tiii <index>");
            writer.println("\t\tReplace any III with a U");
            writer.println("\tuu <index");
            writer.println("\t\tRemove any UU");
            writer.println("\tundo");
            writer.println("\t\tundo your last commands");
            writer.println("\texit");
            writer.println("\t\texit the game");
            return;
        }

        if (action.equalsIgnoreCase("add u")) {
            game.appendU();
            return;
        }

        if (action.equalsIgnoreCase("double")) {
            game.doubleStringAfterM();
            return;
        }

        if ((m = III_TO_U_PATTERN.matcher(action)).matches()) {
            int index = Integer.valueOf(m.group(1));
            game.replaceIIIWithU(index);
            return;
        }

        if ((m = REMOVE_UU_PATTERN.matcher(action)).matches()) {
            int index = Integer.valueOf(m.group(1));
            game.removeUU(index);
            return;
        }

        if ("undo".equalsIgnoreCase(action)) {
            game.undo();
            return;
        }

        writer.println();
        writer.println("Unrecognized command: \"" + action + "\"");
    }
}

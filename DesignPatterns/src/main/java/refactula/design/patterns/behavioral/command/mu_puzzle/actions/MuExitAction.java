package refactula.design.patterns.behavioral.command.mu_puzzle.actions;

import refactula.design.patterns.behavioral.command.mu_puzzle.MuPuzzleApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MuExitAction extends MuAppAction {
    private static final Pattern PATTERN = Pattern.compile("exit", Pattern.CASE_INSENSITIVE);

    public MuExitAction() {
        super(PATTERN);
    }

    @Override
    protected void doPerform(String action, Matcher matcher, MuPuzzleApp app) {
        app.exit();
    }

    @Override
    public void printHelp(MuPuzzleApp app) {
        app.println("\texit");
        app.println("\t\texit the game");
    }
}

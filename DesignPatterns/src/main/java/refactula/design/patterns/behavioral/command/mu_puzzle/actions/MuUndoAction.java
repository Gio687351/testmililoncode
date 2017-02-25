package refactula.design.patterns.behavioral.command.mu_puzzle.actions;

import refactula.design.patterns.behavioral.command.mu_puzzle.MuPuzzleApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MuUndoAction extends MuAppAction {
    private static final Pattern PATTERN = Pattern.compile("undo", Pattern.CASE_INSENSITIVE);

    public MuUndoAction() {
        super(PATTERN);
    }

    @Override
    protected void doPerform(String action, Matcher matcher, MuPuzzleApp app) {
        app.undo();
    }

    @Override
    public void printHelp(MuPuzzleApp app) {
        app.println("\tundo");
        app.println("\t\tundo your last commands");
    }
}

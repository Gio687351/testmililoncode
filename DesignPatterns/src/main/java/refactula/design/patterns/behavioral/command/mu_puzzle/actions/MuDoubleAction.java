package refactula.design.patterns.behavioral.command.mu_puzzle.actions;

import refactula.design.patterns.behavioral.command.mu_puzzle.MuPuzzleApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MuDoubleAction extends MuAppAction {
    private static final Pattern PATTERN = Pattern.compile("double", Pattern.CASE_INSENSITIVE);

    public MuDoubleAction() {
        super(PATTERN);
    }

    @Override
    protected void doPerform(String action, Matcher matcher, MuPuzzleApp app) {
        app.doubleStringAfterM();
    }

    @Override
    public void printHelp(MuPuzzleApp app) {
        app.println("\tdouble");
        app.println("\t\tDouble the string after the M");
    }
}

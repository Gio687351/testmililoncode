package refactula.design.patterns.behavioral.command.mu_puzzle.actions;

import refactula.design.patterns.behavioral.command.mu_puzzle.MuPuzzleApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MuAddUAction extends MuAppAction {
    private static final Pattern PATTERN = Pattern.compile("add u", Pattern.CASE_INSENSITIVE);

    public MuAddUAction() {
        super(PATTERN);
    }

    @Override
    protected void doPerform(String action, Matcher matcher, MuPuzzleApp app) {
        app.appendU();
    }

    @Override
    public void printHelp(MuPuzzleApp app) {
        app.println("\tadd u");
        app.println("\t\tAdd a U to the end of any string ending in I");
    }
}

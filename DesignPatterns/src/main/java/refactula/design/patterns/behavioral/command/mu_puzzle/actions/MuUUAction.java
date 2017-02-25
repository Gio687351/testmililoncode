package refactula.design.patterns.behavioral.command.mu_puzzle.actions;

import refactula.design.patterns.behavioral.command.mu_puzzle.MuPuzzleApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MuUUAction extends MuAppAction {
    private static final Pattern PATTERN = Pattern.compile("uu ([0-9]{0,3})", Pattern.CASE_INSENSITIVE);

    public MuUUAction() {
        super(PATTERN);
    }

    @Override
    protected void doPerform(String action, Matcher matcher, MuPuzzleApp app) {
        app.removeUU(Integer.valueOf(matcher.group(1)));
    }

    @Override
    public void printHelp(MuPuzzleApp app) {
        app.println("\tuu <index");
        app.println("\t\tRemove any UU");
    }
}

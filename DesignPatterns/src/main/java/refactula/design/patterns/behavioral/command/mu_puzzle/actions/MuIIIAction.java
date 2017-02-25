package refactula.design.patterns.behavioral.command.mu_puzzle.actions;

import refactula.design.patterns.behavioral.command.mu_puzzle.MuPuzzleApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MuIIIAction extends MuAppAction {
    private static final Pattern PATTERN = Pattern.compile("iii ([0-9]{0,3})", Pattern.CASE_INSENSITIVE);

    public MuIIIAction() {
        super(PATTERN);
    }

    @Override
    protected void doPerform(String action, Matcher matcher, MuPuzzleApp app) {
        app.replaceIIIWithU(Integer.valueOf(matcher.group(1)));
    }

    @Override
    public void printHelp(MuPuzzleApp app) {
        app.println("\tiii <index>");
        app.println("\t\tReplace any III with a U");
    }
}

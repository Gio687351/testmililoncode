package refactula.design.patterns.behavioral.command.mu_puzzle.actions;

import refactula.design.patterns.behavioral.command.mu_puzzle.MuPuzzleApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MuAppAction {
    private final Pattern pattern;

    protected MuAppAction(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean perform(String action, MuPuzzleApp app) {
        Matcher matcher = pattern.matcher(action);
        if (!matcher.matches()) {
            return false;
        }
        doPerform(action, matcher, app);
        return true;
    }

    protected abstract void doPerform(String action, Matcher matcher, MuPuzzleApp app);

    public abstract void printHelp(MuPuzzleApp app);
}

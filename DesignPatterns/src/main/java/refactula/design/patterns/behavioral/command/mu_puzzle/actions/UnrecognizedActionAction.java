package refactula.design.patterns.behavioral.command.mu_puzzle.actions;

import refactula.design.patterns.behavioral.command.mu_puzzle.MuPuzzleApp;

import java.util.regex.Matcher;

public class UnrecognizedActionAction extends MuAppAction {
    public UnrecognizedActionAction() {
        super(null);
    }

    @Override
    public boolean perform(String action, MuPuzzleApp app) {
        app.println();
        app.println("Unrecognized command: \"" + action + "\"");
        return true;
    }

    @Override
    protected void doPerform(String action, Matcher matcher, MuPuzzleApp app) {

    }

    @Override
    public void printHelp(MuPuzzleApp app) {

    }
}

package refactula.design.patterns.behavioral.command.mu_puzzle;

import com.google.common.collect.ImmutableList;
import refactula.design.patterns.behavioral.command.mu_puzzle.actions.MuAddUAction;
import refactula.design.patterns.behavioral.command.mu_puzzle.actions.MuAppAction;
import refactula.design.patterns.behavioral.command.mu_puzzle.actions.MuDoubleAction;
import refactula.design.patterns.behavioral.command.mu_puzzle.actions.MuExitAction;
import refactula.design.patterns.behavioral.command.mu_puzzle.actions.MuHelpAction;
import refactula.design.patterns.behavioral.command.mu_puzzle.actions.MuIIIAction;
import refactula.design.patterns.behavioral.command.mu_puzzle.actions.MuUUAction;
import refactula.design.patterns.behavioral.command.mu_puzzle.actions.MuUndoAction;
import refactula.design.patterns.behavioral.command.mu_puzzle.actions.UnrecognizedActionAction;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

public class MuPuzzleApp {
    private final MuPuzzleGame game;
    private final Console console;
    private final List<MuAppAction> actions;

    public static void main(String[] args) {
        MuPuzzleApp app = new MuPuzzleApp(
                new MuPuzzleGame(),
                new Console(
                        new BufferedReader(new InputStreamReader(System.in)),
                        new PrintWriter(new BufferedOutputStream(System.out))),
                ImmutableList.of(
                        new MuHelpAction(),
                        new MuAddUAction(),
                        new MuDoubleAction(),
                        new MuIIIAction(),
                        new MuUUAction(),
                        new MuUndoAction(),
                        new MuExitAction(),
                        new UnrecognizedActionAction()));

        app.play();
    }

    public MuPuzzleApp(MuPuzzleGame game, Console console, List<MuAppAction> actions) {
        this.game = game;
        this.console = console;
        this.actions = actions;
    }

    public void play() {
        try {
            while (!game.isSolved()) {
                String action = askForAction();
                perform(action);
            }
            println();
            println("Congratulations! You have solved the puzzle!");
            flush();
        } catch (ExitError ignored) {}
    }

    private String askForAction() {
        println();
        println("Current game state: " + game.toString());
        println("Please specify your next command (type \"help\" for more info)");
        println();
        print("> ");
        flush();
        return readLine();
    }

    private void perform(String action) {
        if (actions.stream().noneMatch(c -> c.perform(action, this))) {
            throw new RuntimeException("Failed to handle action: " + action);
        }
    }

    public void println() {
        console.println();
    }

    public void println(String s) {
        console.println(s);
    }

    public void flush() {
        console.flush();
    }

    public void print(String s) {
        console.print(s);
    }

    public String readLine() {
        return console.readLine();
    }

    public void appendU() {
        game.appendU();
    }

    public void doubleStringAfterM() {
        game.doubleStringAfterM();
    }

    public void replaceIIIWithU(int index) {
        game.replaceIIIWithU(index);
    }

    public void removeUU(int index) {
        game.removeUU(index);
    }

    public void undo() {
        game.undo();
    }

    public void printHelp() {
        for (MuAppAction component : actions) {
            component.printHelp(this);
        }
    }

    public void exit() {
        throw new ExitError();
    }

    private final class ExitError extends Error {}
}

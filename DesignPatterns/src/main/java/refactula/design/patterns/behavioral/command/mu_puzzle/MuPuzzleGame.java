package refactula.design.patterns.behavioral.command.mu_puzzle;

import refactula.design.patterns.behavioral.command.Command;

import java.util.LinkedList;

public class MuPuzzleGame {
    private final MuPuzzle puzzle = new MuPuzzle();
    private final LinkedList<Command> history = new LinkedList<>();

    public void appendU() {
        perform(puzzle::appendU);
    }

    public void doubleStringAfterM() {
        perform(puzzle::doubleStringAfterM);
    }

    public void replaceIIIWithU(int index) {
        perform(() -> puzzle.replaceIIIWithU(index));
    }

    public void removeUU(int index) {
        perform(() -> puzzle.removeUU(index));
    }

    public void perform(Command command) {
        history.add(command);
        command.execute();
    }

    public void undo() {
        if (!history.isEmpty()) {
            history.removeLast();
            reExecute();
        }
    }

    private void reExecute() {
        puzzle.reset();
        history.forEach(Command::execute);
    }

    @Override
    public String toString() {
        return puzzle.toString();
    }

    public boolean isSolved() {
        return puzzle.toString().equals("MU");
    }
}

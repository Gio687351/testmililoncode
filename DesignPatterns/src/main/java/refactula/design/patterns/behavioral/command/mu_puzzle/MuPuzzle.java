package refactula.design.patterns.behavioral.command.mu_puzzle;

import refactula.design.patterns.behavioral.command.util.Resetable;

public class MuPuzzle implements Resetable {
    private StringBuilder stringBuilder = new StringBuilder();

    public MuPuzzle() {
        reset();
    }

    @Override
    public void reset() {
        stringBuilder.setLength(0);
        stringBuilder.append("MI");
    }

    public void appendU() {
        stringBuilder.append("U");
    }

    public void doubleStringAfterM() {
        for (int i = 1, length = stringBuilder.length(); i < length; i++) {
            stringBuilder.append(stringBuilder.charAt(i));
        }
    }

    public void replaceIIIWithU(int index) {
        if (index + 2 < stringBuilder.length()
                && stringBuilder.charAt(index) == 'I'
                && stringBuilder.charAt(index + 1) == 'I'
                && stringBuilder.charAt(index + 2) == 'I') {
            stringBuilder.setCharAt(index, 'U');
            stringBuilder.delete(index + 1, index + 3);
        }
    }

    public void removeUU(int index) {
        if (index + 1 < stringBuilder.length()
                && stringBuilder.charAt(index) == 'U'
                && stringBuilder.charAt(index + 1) == 'U') {
            stringBuilder.delete(index, index + 2);
        }
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}

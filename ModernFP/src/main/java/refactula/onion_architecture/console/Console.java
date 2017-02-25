package refactula.onion_architecture.console;

import refactula.onion_architecture.functional.Algebra;

public interface Console {

    Algebra<String> readLine();

    Algebra<Void> writeLine(String line);

    static Algebra<String> readLine(Console f) {
        return f.readLine();
    }

    static Algebra<Void> writeLine(Console f, String line) {
        return f.writeLine(line);
    }

}

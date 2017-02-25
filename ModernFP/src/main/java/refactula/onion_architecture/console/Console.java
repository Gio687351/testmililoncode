package refactula.onion_architecture.console;

import refactula.onion_architecture.functional.Type;

public interface Console {

    Type<String> readLine();

    Type<Void> writeLine(String line);

    static Type<String> readLine(Console f) {
        return f.readLine();
    }

    static Type<Void> writeLine(Console f, String line) {
        return f.writeLine(line);
    }

}

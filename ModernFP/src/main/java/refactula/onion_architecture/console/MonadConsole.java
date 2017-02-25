package refactula.onion_architecture.console;

import refactula.onion_architecture.functional.Monad;

public interface MonadConsole extends Console {

    @Override
    Monad<String> readLine();

    @Override
    Monad<Void> writeLine(String line);

}

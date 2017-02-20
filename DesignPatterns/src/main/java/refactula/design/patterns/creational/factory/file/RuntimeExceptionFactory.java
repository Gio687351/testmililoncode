package refactula.design.patterns.creational.factory.file;

public interface RuntimeExceptionFactory {

    RuntimeException throwBecause(String message);

    RuntimeException throwBecause(String message, Throwable cause);

}

package refactula.design.patterns.factory.file;

public interface RuntimeExceptionFactory {

    RuntimeException throwBecause(String message);

    RuntimeException throwBecause(String message, Throwable cause);

}

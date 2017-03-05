package refactula.design.patterns.behavioral.interpreter;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Program;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Variable;
import refactula.design.patterns.behavioral.interpreter.interpreter.InterpretingProgramExecutor;

import java.io.IOException;

import static refactula.design.patterns.behavioral.interpreter.DSL.*;

public class SampleProgram {

    public static void main(String[] args) throws IOException {
        ProgramExecutor programExecutor = InterpretingProgramExecutor.create();
        programExecutor.execute(program());
    }

    private static Program program() {
        Variable username = Variable();
        Variable password = Variable();
        return Program(Sequence(
                Show(Constant("Enter username")),
                Read(username),
                Show(Constant("Enter password")),
                Read(password),
                If(And(Equals(username, Constant("gendalf")), Equals(password, Constant("youshallnowpass"))),
                        Sequence(Show(Concat(Constant("Welcome, "), username, Constant("!")))),
                        Sequence(Show(Constant("Rejected"))))));
    }

}

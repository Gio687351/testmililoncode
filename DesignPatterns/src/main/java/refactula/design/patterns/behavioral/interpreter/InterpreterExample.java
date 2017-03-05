package refactula.design.patterns.behavioral.interpreter;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Program;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Variable;
import refactula.design.patterns.behavioral.interpreter.interpreter.InterpretingProgramExecutor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static refactula.design.patterns.behavioral.interpreter.DSL.*;

public class InterpreterExample {

    public static void main(String[] args) throws Exception {
        byte[] bytes = serializeProgramToBytes();
        interpretBytes(bytes);
    }

    private static byte[] serializeProgramToBytes() throws IOException {
        ByteArrayOutputStream network = new ByteArrayOutputStream();
        try (ObjectOutputStream objectWriter = new ObjectOutputStream(network)) {
            objectWriter.writeObject(program());
        }
        return network.toByteArray();
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

    private static void interpretBytes(byte[] bytes) throws Exception {
        ProgramExecutor programExecutor = InterpretingProgramExecutor.create();
        try (ObjectInputStream objectReader = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
            Program program = (Program) objectReader.readObject();
            programExecutor.execute(program);
        }
    }

}

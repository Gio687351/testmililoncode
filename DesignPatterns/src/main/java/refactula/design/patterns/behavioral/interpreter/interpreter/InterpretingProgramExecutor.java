package refactula.design.patterns.behavioral.interpreter.interpreter;

import com.google.common.collect.ImmutableList;
import refactula.design.patterns.behavioral.interpreter.ProgramExecutor;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Program;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.BooleanType;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.CommandType;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.ProgramType;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.StringType;
import refactula.design.patterns.behavioral.interpreter.interpreter.classes.*;

public class InterpretingProgramExecutor implements ProgramExecutor {
    private final RootInterpreter rootInterpreter;

    public static InterpretingProgramExecutor create() {
        IO inputOutput = ConsoleIO.systemIO();
        VariableInterpreter variableInterpreter = new VariableInterpreter();
        return new InterpretingProgramExecutor(new RootInterpreter(

                new ChainInterpreter<>(ProgramType.class, ImmutableList.of(
                        new ProgramInterpreter())),

                new ChainInterpreter<>(StringType.class, ImmutableList.of(
                        new ConcatInterpreter(),
                        new ConstantInterpreter(),
                        variableInterpreter)),

                new ChainInterpreter<>(CommandType.class, ImmutableList.of(
                        new IfInterpreter(),
                        new ReadInterpreter(inputOutput, variableInterpreter),
                        new SequenceInterpreter(),
                        new ShowInterpreter(inputOutput))),

                new ChainInterpreter<>(BooleanType.class, ImmutableList.of(
                        new EqualsInterpreter(),
                        new AndInterpreter()))

        ));
    }

    private InterpretingProgramExecutor(RootInterpreter rootInterpreter) {
        this.rootInterpreter = rootInterpreter;
    }

    @Override
    public void execute(Program program) {
        rootInterpreter.interpret(program);
    }
}

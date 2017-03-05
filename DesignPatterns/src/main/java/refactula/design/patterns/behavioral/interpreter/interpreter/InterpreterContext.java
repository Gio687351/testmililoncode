package refactula.design.patterns.behavioral.interpreter.interpreter;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.BooleanType;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.CommandType;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.ProgramType;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.StringType;

public interface InterpreterContext {

    void interpret(ProgramType program);

    String interpret(StringType string);

    void interpret(CommandType command);

    boolean interpret(BooleanType booleanType);

}

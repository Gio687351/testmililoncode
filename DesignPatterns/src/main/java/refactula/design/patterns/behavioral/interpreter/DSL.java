package refactula.design.patterns.behavioral.interpreter;

import com.google.common.collect.ImmutableList;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Concat;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Constant;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Equals;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.If;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Program;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Read;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Sequence;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Show;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Variable;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.BooleanType;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.CommandType;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.StringType;

public final class DSL {
    public static Variable Variable() {
        return new Variable();
    }

    public static Constant Constant(String text) {
        return new Constant(text);
    }

    public static Concat Concat(StringType... values) {
        return new Concat(ImmutableList.copyOf(values));
    }

    public static Equals Equals(StringType first, StringType second) {
        return new Equals(first, second);
    }

    public static If If(BooleanType condition, CommandType trueBranch, CommandType falseBranch) {
        return new If(condition, trueBranch, falseBranch);
    }

    public static Read Read(Variable variable) {
        return new Read(variable);
    }

    public static Show Show(StringType text) {
        return new Show(text);
    }

    public static Sequence Sequence(CommandType... commands) {
        return new Sequence(ImmutableList.copyOf(commands));
    }

    public static Program Program(CommandType command) {
        return new Program(command);
    }
}

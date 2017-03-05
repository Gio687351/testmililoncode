package refactula.design.patterns.behavioral.interpreter.interpreter.classes;

import com.google.common.base.Preconditions;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Variable;
import refactula.design.patterns.behavioral.interpreter.interpreter.Interpreter;
import refactula.design.patterns.behavioral.interpreter.interpreter.InterpreterContext;

import java.util.HashMap;
import java.util.Map;

public class VariableInterpreter extends Interpreter<Variable, String> {

    private final Map<Variable, String> values = new HashMap<>();

    public VariableInterpreter() {
        super(Variable.class);
    }

    @Override
    protected String doInterpret(InterpreterContext context, Variable variable) {
        Preconditions.checkState(values.containsKey(variable));
        return values.get(variable);
    }

    public void init(Variable variable, String value) {
        Preconditions.checkState(!values.containsKey(variable));
        values.put(variable, value);
    }

}

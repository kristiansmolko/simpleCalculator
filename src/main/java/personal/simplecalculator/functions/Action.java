package personal.simplecalculator.functions;

import java.util.ArrayList;
import java.util.List;

public class Action {
    private static final Action action = null;
    private final List<Function> functions;

    private Action(){
        functions = new ArrayList<>();
    }

    public static Action getInstance(){
        return action==null ? new Action() : action;
    }

    public void addFunction(Function function){
        functions.add(function);
    }

    public List<Function> getFunctions(){
        return functions;
    }
}

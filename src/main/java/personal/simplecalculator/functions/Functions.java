package personal.simplecalculator.functions;

import java.util.List;

public class Functions {
    private final List<Function> functionList;
    private String exercise;

    public Functions(Action action){
        functionList = action.getFunctions();
    }

    public void setExercise(String exercise){
        this.exercise = exercise;
    }

    private void addFunctionsFromExercise(){
        if (exercise.contains("+")) functionList.add(Function.ADDING);
        if (exercise.contains("-")) functionList.add(Function.SUBSTRACT);
        if (exercise.contains("*")) functionList.add(Function.MULTIPLY);
        if (exercise.contains("/")) functionList.add(Function.DIVIDE);
    }

    private int[] processExercise(){
        addFunctionsFromExercise();
        if (isSingleFunction()) {
            var operand = functionList.get(0).getOperand();
            var temp =exercise.split(operand);
            var numbers = new int[2];
            numbers[0] = Integer.parseInt(temp[0]);
            numbers[1] = Integer.parseInt(temp[1]);
            return numbers;
        }
        return null;
    }

    public int getResult(){
        var numbers = processExercise();
        assert numbers != null : "Numbers should not be null";
        if (isSingleFunction()){
            switch(functionList.get(0).getValue()){
                case 0: return numbers[0] + numbers[1];
                case 1: return numbers[0] - numbers[1];
                case 2: return numbers[0] * numbers[1];
                case 3: return numbers[0] / numbers[1];
            }
        }
        return 0;
    }

    private boolean isSingleFunction(){
        return functionList.size()==1;
    }




}

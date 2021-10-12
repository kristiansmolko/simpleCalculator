package personal.simplecalculator.functions;

import java.util.ArrayList;
import java.util.List;

public class Functions {
    private final List<Function> functionList;
    private String exercise;
    private int[] numbers = new int[2];

    public Functions(){
        functionList = new ArrayList<>();
    }

    public void setExercise(String exercise){
        this.exercise = exercise;
    }

    private void addFunctionsFromExercise(){
        for (var characterNumber = 0; characterNumber < exercise.length(); ++characterNumber){
            var character = exercise.charAt(characterNumber);
            switch(character){
                case '+' -> functionList.add(Function.ADDING);
                case '-' -> functionList.add(Function.SUBTRACT);
                case '*' -> functionList.add(Function.MULTIPLY);
                case '/' -> functionList.add(Function.DIVIDE);
            }
        }
    }

    private int[] processExercise(){
        addFunctionsFromExercise();
        checkForFirstNegativeNumberAndAdd();
        if (isSingleFunction()) {
            var operand = functionList.get(0).getOperand();
            var temp =exercise.split(operand);
            if (numbers[0] == 0) {
                numbers = new int[2];
                numbers[0] = Integer.parseInt(temp[0]);
            }
            numbers[1] = Integer.parseInt(temp[1]);
            return numbers;
        }
        return new int[0];
    }

    public int getResult(){
        var exerciseNumbers = processExercise();
        if (isSingleFunction()){
            switch(functionList.get(0).getValue()){
                case 0: return exerciseNumbers[0] + exerciseNumbers[1];
                case 1: return exerciseNumbers[0] - exerciseNumbers[1];
                case 2: return exerciseNumbers[0] * exerciseNumbers[1];
                case 3: return exerciseNumbers[0] / exerciseNumbers[1];
            }
        }
        return 0;
    }

    private boolean checkForNegativeFirstNumber(){
        return exercise.charAt(0) == '-';
    }

    private void addFirstNegativeNumber(){
        var operand = functionList.get(0).getOperand();
        var temp = exercise.split(operand);
        numbers[0] = -(Integer.parseInt(temp[0]));
    }

    private void removeSubtraction() {
        functionList.remove(Function.SUBTRACT);
        exercise = exercise.replaceFirst("-", "");
    }

    private void checkForFirstNegativeNumberAndAdd(){
        if (checkForNegativeFirstNumber()) {
            removeSubtraction();
            addFirstNegativeNumber();
        }
    }

    private boolean isSingleFunction(){
        return functionList.size()==1;
    }

}

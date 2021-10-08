package personal.simplecalculator.functions;

public enum Function {
    ADDING(0, "\\+"),
    SUBSTRACT(1, "\\-"),
    MULTIPLY(2, "\\*"),
    DIVIDE(3, "\\/");

    private final int value;
    private final String operand;

    Function(int function, String operand){
        value = function;
        this.operand = operand;
    }

    public int getValue(){
        return this.value;
    }

    public String getOperand(){
        return this.operand;
    }

}

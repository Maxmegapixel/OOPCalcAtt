package Calculator.util;

public enum Operators {
    PLUS("+"),  MULTI("*"), DIVIDE("/");

    private final String operator;

    Operators(String operator) {
        this.operator = operator;
    }

    public String operator() {
        return operator;
    }
}

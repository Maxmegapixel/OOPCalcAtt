package Calculator.model.calc.impl;

import Calculator.model.ComplexNumber;
import Calculator.model.calc.ComplexCalculable;

public class LogableCalc implements ComplexCalculable {
    private final ComplexCalculable calculable ;

    public LogableCalc(ComplexCalculable calculable) {
        this.calculable = calculable;
    }

    @Override
    public ComplexNumber sum(ComplexNumber a, ComplexNumber b) {
        System.out.println(String.format("Суммирую %s и %s", a, b));
        return calculable.sum(a, b);
    }

    @Override
    public ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
        System.out.println(String.format("Умножаю %s и %s", a, b));
        return calculable.multiply(a, b);
    }

    @Override
    public ComplexNumber divide(ComplexNumber a, ComplexNumber b) {
        System.out.println(String.format("Вычитаю %s и %s", a, b));
        return calculable.divide(a, b);
    }
}

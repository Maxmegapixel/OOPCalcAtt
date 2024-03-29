package Calculator;

import Calculator.controller.CalculatorController;
import Calculator.model.calc.impl.ComplexCalc;
import Calculator.model.calc.impl.LogableCalc;
import Calculator.view.ViewConsole;

public class Main {
    public static void main(String[] args) {

        CalculatorController calc = new CalculatorController(
                new LogableCalc(new ComplexCalc()), new ViewConsole());
        calc.run();

    }
}
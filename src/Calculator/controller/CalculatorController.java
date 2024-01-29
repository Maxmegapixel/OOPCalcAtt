package Calculator.controller;

import Calculator.model.ComplexNumber;
import Calculator.model.calc.ComplexCalculable;
import Calculator.util.Operators;
import Calculator.view.ViewConsole;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CalculatorController {
    private final ComplexCalculable calculator;
    private final ViewConsole view;

    private final List<String> validOperators;


    public CalculatorController(ComplexCalculable calculator, ViewConsole view) {
        this.view = view;
        this.calculator = calculator;
        this.validOperators = Arrays.stream(Operators.values())
                .map(Operators::operator)
                .collect(Collectors.toList());
    }


    public void run() {
        while (true) {
            prepare();
            String action = prompt();
            if (!action.equalsIgnoreCase("y")) {
                System.exit(0);
            }
        }
    }

    private void prepare() {
        try {
            double realA = Double.parseDouble(view.getInput("Enter real part of number A"));
            double imaginaryA = Double.parseDouble(view.getInput("Enter imaginary part of number A"));
            String operator = getOperator();
            double realB = Double.parseDouble(view.getInput("Enter real part of number B"));
            double imaginaryB = Double.parseDouble(view.getInput("Enter imaginary part of number B"));
            ComplexNumber a = new ComplexNumber(realA, imaginaryA);
            ComplexNumber b = new ComplexNumber(realB, imaginaryB);
            ComplexNumber result = null;
            if (operator.equals("*")) {
                result = calculator.multiply(a, b);
            }

            if (operator.equals("+")) {
                result = calculator.sum(a, b);
            }

            if (operator.equals("/")) {
                result = calculator.divide(a, b);
            }


            view.displayResult(result.toString());
        } catch (NumberFormatException e) {
            view.displayError("Invalid input. Please enter valid numbers.");

        }


    }

    private String prompt() {
        Scanner in = new Scanner(System.in);
        System.err.println("Continue?... (y/n)");
        return in.nextLine();
    }

    private String getOperator() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the math operation (*, +, /) : ");
        String operator = in.nextLine();
        while (true) {
            if (isInvalidOperator(operator)) {
                System.err.println("Entered invalid math operator. " + "Enter the math operation (*, +, /) : ");
                operator = in.nextLine();
            } else return operator;
        }
    }

    private boolean isInvalidOperator(String operator) {
        return !validOperators.contains(operator);
    }


}

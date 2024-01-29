package Calculator.view;

import java.util.Scanner;

public class ViewConsole {
    private Scanner scanner = new Scanner(System.in);


    public void displayResult(String result) {
        System.out.println("Result: " + result);
    }

    public void displayError(String errorMessage) {
        System.err.println("Error: " + errorMessage);
    }

    public String getInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }
}

package Calculator.model.calc;

import Calculator.model.ComplexNumber;

public interface ComplexCalculable {
    ComplexNumber sum(ComplexNumber a, ComplexNumber b);
    ComplexNumber multiply(ComplexNumber a, ComplexNumber b);
    ComplexNumber divide(ComplexNumber a, ComplexNumber b);

}

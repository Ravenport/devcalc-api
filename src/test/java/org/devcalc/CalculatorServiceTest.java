package org.devcalc;

import net.jqwik.api.*;
import org.assertj.core.api.Assertions;
import org.devcalc.models.OperationValues;
import org.devcalc.services.CalculatorService;

public class CalculatorServiceTest {

    @Provide
    private Arbitrary<OperationValues> validOperationValuesProvider() {
        Arbitrary<Double> firstValue = Arbitraries.doubles().between(0, 100000);
        Arbitrary<Double> secondValue = Arbitraries.doubles().between(0, 100000);
        return Combinators.combine(firstValue, secondValue).as(OperationValues::new);
    }

    @Property
    void calculatorServiceAddTest(@ForAll("validOperationValuesProvider") OperationValues values) {
        CalculatorService service = new CalculatorService();
        Double result = values.getFirstValue() + values.getSecondValue();
        Assertions.assertThat(service.add(values)).isEqualTo(result);
    }

    @Property
    void calculatorServiceSubtractTest(@ForAll("validOperationValuesProvider") OperationValues values) {
        CalculatorService service = new CalculatorService();
        Double result = values.getFirstValue() - values.getSecondValue();
        Assertions.assertThat(service.subtract(values)).isEqualTo(result);
    }

    @Property
    void calculatorServiceMultiplyTest(@ForAll("validOperationValuesProvider") OperationValues values) {
        CalculatorService service = new CalculatorService();
        Double result = values.getFirstValue() * values.getSecondValue();
        Assertions.assertThat(service.multiply(values)).isEqualTo(result);
        
    }

    @Property
    void calculatorServiceDivideTest(@ForAll("validOperationValuesProvider") OperationValues values) {
        CalculatorService service = new CalculatorService();
        Double result = values.getFirstValue() / values.getSecondValue();
        Assertions.assertThat(service.divide(values)).isEqualTo(result);
    }
}

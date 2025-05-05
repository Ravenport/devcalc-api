package org.devcalc.services;

import io.javalin.http.Context;
import org.devcalc.models.OperationValues;

public class CalculatorService {
    public Double add(OperationValues values) {
        return values.getFirstValue() + values.getSecondValue();
    }

    public Double subtract(OperationValues values) {
        return values.getFirstValue() - values.getSecondValue();
    }

    public Double multiply(OperationValues values) {
        return values.getFirstValue() * values.getSecondValue();
    }

    public Double divide(OperationValues values) {
        return values.getFirstValue() / values.getSecondValue();
    }
}

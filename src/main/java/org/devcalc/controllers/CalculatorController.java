package org.devcalc.controllers;

import io.javalin.http.Context;
import org.devcalc.models.OperationValues;
import org.devcalc.services.CalculatorService;

public class CalculatorController {
    private final CalculatorService service;

    public CalculatorController(CalculatorService calculatorService) {
        service = calculatorService;
    }

    public Double getAdd(Context context) {
        OperationValues values = context.bodyAsClass(OperationValues.class);
        return service.add(values);
    }

    public Double getSubtract(Context context) {
        OperationValues values = context.bodyAsClass(OperationValues.class);
        return service.subtract(values);
    }

    public Double getMultiply(Context context) {
        OperationValues values = context.bodyAsClass(OperationValues.class);
        return service.multiply(values);
    }

    public Double getDivide(Context context) {
        OperationValues values = context.bodyAsClass(OperationValues.class);
        return service.divide(values);
    }
}

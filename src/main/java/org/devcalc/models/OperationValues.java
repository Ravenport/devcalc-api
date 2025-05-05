package org.devcalc.models;

import lombok.Getter;

@Getter
public class OperationValues {
    private final double firstValue;
    private final double secondValue;

    public OperationValues(double firstValue, double secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }
}

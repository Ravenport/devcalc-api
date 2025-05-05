package org.devcalc;

import io.javalin.Javalin;
import org.devcalc.controllers.CalculatorController;
import org.devcalc.services.CalculatorService;
public class Main {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(
            new CalculatorService()
        );

        Javalin app = Javalin.create()
        .get(
            "/add/{firstValue}/{secondValue}",
            context -> {
                context.json(calculatorController.getAdd(context));
            }
        )
        .get(
            "/subtract/{firstValue}/{secondValue}",
            context -> {
                context.json(calculatorController.getSubtract(context));
            }
        )
        .get(
            "/multiply/{firstValue}/{secondValue}",
            context -> {
                context.json(calculatorController.getMultiply(context));
            }
        )
        .get(
            "/divide/{firstValue}/{secondValue}",
            context -> {
                context.json(calculatorController.getDivide(context));
            }
        )
        .start(8080);
    }
}
package edu.austral.ingsis.math.operaciones;

import edu.austral.ingsis.math.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Module implements Function {
    private final Function number1;


    public Module(Function number1) {
        this.number1 = number1;

    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return Math.abs(number1.evaluate(map));
    }

    @Override
    public List<String> getVariables() {
        List<String> result = new ArrayList<>(number1.getVariables());
        return result;


    }

    @Override
    public String toString() {
        return getString(number1, "|");
    }

    private String getString(Function number1, String operation) {
        return "(" + operation + number1.toString() + operation + ")";
    }
}

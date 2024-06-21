package edu.austral.ingsis.math.operaciones;

import edu.austral.ingsis.math.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Substraction implements Function {
  private final Function number1;
  private final Function number2;

  public Substraction(Function number1, Function number2) {
    this.number1 = number1;
    this.number2 = number2;
  }

  @Override
  public double evaluate(Map<String, Double> map) {
    return number1.evaluate(map) - number2.evaluate(map);
  }

  @Override
  public List<String> getVariables() {
    List<String> result = new ArrayList<>(number1.getVariables());
    result.addAll(number2.getVariables());
    return result;
  }

  @Override
  public String toString() {
    return getString(number1, number2, "-");
  }

  private String getString(Function number1, Function number2, String operation) {
    return "(" + number1.toString() + operation + number2.toString() + ")";
  }
}

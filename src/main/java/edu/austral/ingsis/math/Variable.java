package edu.austral.ingsis.math;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Variable implements Function {
  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public double evaluate(Map<String, Double> map) {
    if (!map.containsKey(name)) {
      throw new IllegalArgumentException("No value provided for variable: " + name);
    }
    return map.get(name);
  }

  @Override
  public List<String> getVariables() {
    return Collections.singletonList(name);
  }

  @Override
  public String toString() {
    return name;
  }
}

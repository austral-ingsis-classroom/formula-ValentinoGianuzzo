package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.operaciones.*;
import edu.austral.ingsis.math.operaciones.Module;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final List<String> result = Collections.emptyList();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    List<String> result = Collections.emptyList();
    Function function = new Division(new Number(12), new Variable("div"));
    result = function.getVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    List<String> result = Collections.emptyList();
    // Crear la función que representa la expresión (9 / x) * y
    Function function =
        new Multiplication(new Division(new Number(9), new Variable("x")), new Variable("y"));
    result = function.getVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    List<String> result = Collections.emptyList();
    Function function =
        new Power(new Division(new Number(27), new Variable("a")), new Variable("b"));
    result = function.getVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    List<String> result = Collections.emptyList();
    Function function = new Power(new Variable("z"), new Division(new Number(1), new Number(2)));
    result = function.getVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    List<String> result = Collections.emptyList();
    Function function = new Substraction(new Module(new Variable("value")), new Number(8));
    result = function.getVariables();
    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    List<String> result = Collections.emptyList();
    Function function = new Substraction(new Module(new Variable("value")), new Number(8));
    result = function.getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    List<String> result = Collections.emptyList();
    Function function =
        new Multiplication(new Substraction(new Number(5), new Variable("i")), new Number(8));
    result = function.getVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}

package edu.lernia.labb5;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class YatziTest {

  // Declare the common objects as fields
  private YatziGame yatziGame;
  private Die[] dice;

  // Use the @BeforeEach annotation to set up the common objects before each test
  @BeforeEach
  public void setUp() {
    // Create a YatziGame object
    yatziGame = new YatziGame();

    // Create an array of Die objects
    dice = new Die[5];

    // Use reflection to access the private field die and set its value to the dice array
    try {
      Field dieField = YatziGame.class.getDeclaredField("die");
      dieField.setAccessible(true);
      dieField.set(yatziGame, dice);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  @Test
  void whenAllDiceMatches_thenAssertThatUserGotYatzi() {
    // Arrange: Set all dice values to 6
    int yatziValue = 6;
    for (int i = 0; i < dice.length; i++) {
      dice[i] = new Die(yatziValue);
    }

    // Act: Call the userGotYatzi method
    boolean result = yatziGame.userGotYatzi();

    // Assert: Check if the result is true
    assertThat(result).isTrue();
  }
}

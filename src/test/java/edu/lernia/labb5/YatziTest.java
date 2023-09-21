package edu.lernia.labb5;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class YatziTest {

    @Test
    void whenAllDiceMatches_thenAssertThatUserGotYatzi() {
        // Arrange: Create a YatziGame object and an array of Die objects with the same value

        YatziGame yatziGame = new YatziGame();

        // Act: Set all dice values to 6
        Die[] dice = new Die[5];
        int yatziValue = 6;
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die(yatziValue);
        }

        // Use reflection to access the private field die and set its value to the dice array
        try {
            Field dieField = YatziGame.class.getDeclaredField("die");
            dieField.setAccessible(true);
            dieField.set(yatziGame, dice);
          } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
          }
      
          // Act: Call the userGotYatzi method
          boolean result = yatziGame.userGotYatzi();
      
          // Assert: Check if the result is true
          assertThat(result).isTrue();
        }
    }

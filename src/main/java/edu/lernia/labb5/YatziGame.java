package edu.lernia.labb5;

import java.util.Scanner;

public class YatziGame {
  private Die[] die;
  private boolean gameIsOn = true;

  public YatziGame() {
    die = new Die[5];
    for (int d = 0; d < 5; d++) {
      die[d] = new Die();
    }
  }

  public void start() {
    while (gameIsOn) {
      playTurn();

      if (userGotYatzi()) {
        gameIsOn = false;
      }
    }
  }

  private void playTurn() {
    int turn = 0;
    boolean shouldCheckRollAgain = true;

    System.out.println("Welcome to Yatzi!");

    while (turn < 3) {
      System.out.println("Starting turn " + (turn + 1) + " of 3, rolling dice.");

      for (int i = 0; i < die.length; i++) {
        die[i].roll();
        System.out.println(i + ": " + die[i].getValueAsString());
      }

      if (shouldCheckRollAgain && userWishesToRollAgain()) {
        turn++;
      } else {
        break; // Exit the turn loop if the user doesn't wish to roll again
      }

      // After the third roll, set shouldCheckRollAgain to false
      if (turn == 2) {
        shouldCheckRollAgain = false;
      }

    }

    if (userWishesToPlayAgain()) {
      turn = 0;
    } else {
      gameIsOn = false;
    }
  }

  boolean userGotYatzi() {
    for (int j = 1; j < 5; j++) {
      if (die[j].getValue() != die[j - 1].getValue()) {
        return false; // If any dice doesn't match, it's not a Yatzi
      }
    }

    System.out.println("You got YATZI! in " + die[0].getValue() + "'s");
    return true; // All dice match, it's a Yatzi
  }

  private boolean userWishesToRollAgain() {
    System.out.println("Want to roll again? (y for yes, anything else for no)");
    Scanner scanner = new Scanner(System.in);
    return scanner.next().equals("y");
  }

  private boolean userWishesToPlayAgain() {
    System.out.println("Game over! Want to play again? (y for yes, anything else for no)");
    Scanner scanner = new Scanner(System.in);
    return scanner.next().equals("y");
  }
}

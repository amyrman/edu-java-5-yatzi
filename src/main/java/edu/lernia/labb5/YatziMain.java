package edu.lernia.labb5;

import java.util.Scanner;

public class YatziMain {
    public static Die[] die;
    public static boolean isGameOver = false;

    public static void main(String[] args) {
        int round = 0;
        die = new Die[5];
        for (int d = 0; d < 5; d++) { // TODO: Reduce nesting
            die[d] = new Die();
        }
        // We will continue until the game is over
        while (isGameOver == false) {
            round = 0;
            System.out.println("Welcome to Yatzi!");
            while (round < 3) {
                System.out.println("Starting round " + (round + 1) + " of 3, rolling dice.");
                for (int i = 0; i < die.length; i++) {
                    die[i].DieRoll();
                    // die[i].value = 5; //Test if yatzi work
                    System.out.println(i + ": " + die[i].getString());
                }
                // YATZI
                boolean flag = true;
                for (int j = 1; j < 5; j++) {
                    if (die[j].value != die[j - 1].value) {
                        // Set flag to false
                        flag = false;
                    }
                }
                if (flag == true) {
                    System.out.println("Holy moly, you got ze YATZI! in " + die[0].value + "'s");
                    return;
                } else {
                    // Here we check if there is no Yatzy: then we check what round we are on and
                    // asks the player if we want to continue or not
                    if (round != 2) {
                        System.out.println("Want to throw again? (y for yes, anything else for no)");
                        Scanner scanner = new Scanner(System.in);
                        if (scanner.next().equals("y")) {
                            ++round;
                        } else {
                            isGameOver = !isGameOver;
                            break;
                        }
                        scanner.close();
                    } else {
                        System.out.println("Game over! Want to play again?");
                        Scanner scanner = new Scanner(System.in);
                        if (scanner.next().equals("y")) {
                            round = 0;
                        } else {
                            isGameOver = !isGameOver;
                            break;
                        }
                        scanner.close();
                    }
                }
            }
        }
    }
}
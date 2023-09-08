package edu.lernia.labb5;

import java.util.Scanner;

public class YatziMain { // separera logik till annan klass
    // samling med tärningar --> bg material
    
    public static boolean isGameOn = true;

    public static void main(String[] args) {
        int round = 0;
        
        die = new Die[5];
        for (int d = 0; d < 5; d++) { // TODO: Reduce nesting
            die[d] = new Die();
        }
        // We will continue until the game is over
        while (isGameOn == true) {
            round = 0;
            System.out.println("Welcome to Yatzi!");
            while (round < 3) {
                System.out.println("Starting round " + (round + 1) + " of 3, rolling dice.");
                for (int i = 0; i < die.length; i++) {
                    die[i].DieRoll();
                    // die[i].value = 5; //Test if yatzi work
                    System.out.println(i + ": " + die[i].getDiceValueAsString());
                }
                // YATZI
                boolean gotYatzi = true;
                for (int j = 1; j < 5; j++) {
                    if (die[j].value != die[j - 1].value) {
                        // Set yatzi to false
                        gotYatzi = false;
                    }
                }
                if (gotYatzi == true) {
                    System.out.println("You got YATZI! in " + die[0].value + "'s");
                    return;
                } else {
                    // Here we check if there is no Yatzy: then we check what round we are on and asks the player if we want to continue or not
                    if (round != 2) {
                        System.out.println("Want to throw again? (y for yes, anything else for no)");
                        Scanner scanner = new Scanner(System.in);
                        if(scanner.next().equals("y")) {
                            ++round;
                        } else {
                            isGameOn = !isGameOn;
                            break;
                        }
                    } else {
                        System.out.println("Game over! Want to play again?");
                        Scanner scanner = new Scanner(System.in);
                        if (scanner.next().equals("y")) {
                            round = 0;
                        } else {
                            isGameOn = !isGameOn;
                            break;
                        }
                        // scanner.close();
                    }
                }
            }
        }
    }
}

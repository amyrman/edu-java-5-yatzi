package edu.lernia.labb5;

public class BoardGameMaterial {
    /* Will be used to store all boardgamematerials in one class */

// create a set of dice that is called in YatziMain
public static Die[] die; // static = behöver inte göra objekt

public BoardGameMaterial() {
    /* Skapar vi upp 5 st tärningar och lägger in i samlingen av tärningar */
    die = new Die[5];
    }
}

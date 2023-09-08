package edu.lernia.labb5;

public class Die extends BoardGameMaterial { // why extend?
    public int value = 0;

    public Die() {
        value = dieRoll();
    }

    public int dieRoll() {
        return (int)(Math.random()*6+1);
    }

    public String getDiceValueAsString() {
        return "Dice shows " + value;
    }
}

/* SOLID */

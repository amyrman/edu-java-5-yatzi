package edu.lernia.labb5;

public class Die {
    private int value;

    public Die() {
        roll(); // Initialize the die value by rolling it during construction.
    }

    // Constructor for setting the die value for testing
    public Die(int value) {
        this.value = value;
    }

    // Simulate rolling the die and setting its value.
    public void roll() {
        value = diceRoll();
    }

    private int diceRoll() {
        return (int) (Math.random() * 6 + 1);
    }

    public String getValueAsString() {
        return "Dice shows " + value;
    }

    public int getValue() {
        return value;
    }
}

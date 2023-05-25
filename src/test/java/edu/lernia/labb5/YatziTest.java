/*
Uppgiften går ut på att:

- Få koden så läsbar som möjligt genom att refaktorera koden
    - (dvs koden ska fungera på exakt samma sätt som den redan gör idag, men vara enkel att förstå och sätta sig in i för nya personer).

- Ni ska också ha fyllt i testkod som testar:
    - om det blir Yatzi om alla tärningar är lika
    - att det inte är Yatzi när en tärning inte matchar (dessa tester finns påbörjade i YatziTest.java).
    - Ni får gärna skriva fler test om det hjälper er med refaktoreringen, det är dock inget krav.
    
- Tips:​
    - Bryt ut kod i mindre metoder, rensa bort sådant som inte används och se till att det inte finns duplicerad kod någonstans.
    - Namnge även variabler, metoder och klasser utifrån vad de gör.

- Från föreläsning:
    - Plocka ut metoder och lägg dem i bg material
    - Döp om klasser och metoder
    - Lös upp nestade grejer så mycket som möjligt
    
*/

package edu.lernia.labb5;

import org.junit.jupiter.api.Test;

import edu.lernia.labb5.Die;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class YatziTest {
    
    @Test
    void whenAllDiceMatches_thenPrintYatziFeedbackAndAskIfUserWantsToPlayAgain() {
        Die[] dice = new Die[5];
        for(Die die: dice) {
            die.value = 6;
        }
        //Assert something?
    }

    @Test
    void whenOneDieIsNotMatchingAnother_thenAskUserIfUserWantsToReroll() {
        Die[] dice = new Die[5];
        for(Die die: dice) {
            die.value = 6;
        }
        dice[5].value = 1;
        //Assert something?
    }

    @Test
    void whenNoYatziAfterThreeRounds_thenPrintNoYatziAndAskForAnotherGame() {
        Die[] dice = new Die[5];
        for(Die die: dice) {
            die.value = 6;
        }
        dice[5].value = 1;
        //Assert something?
    }
}

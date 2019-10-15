package fr.lacombe.yatzy.category;

import fr.lacombe.yatzy.Roll;
import fr.lacombe.yatzy.ScoreCompute;

public class ThreeOfAKindCategory implements ScoreCompute {

    public int score(Roll roll) {
        int[] tallies = roll.occurrenceOfEachValue();
        for (int diceValue = 6; diceValue >= 1; diceValue--) {
            if (tallies[diceValue - 1] >= 3) {
                return (diceValue) * 3;
            }
        }
        return 0;
    }
}
package fr.lacombe.yatzy.category;

import fr.lacombe.yatzy.Roll;
import fr.lacombe.yatzy.ScoreCompute;

public class TwoPairCategory implements ScoreCompute {

    public int score(Roll roll) {
        int[] tallies = roll.occurrenceOfEachValue();
        int numberOfPair = 0;
        int score = 0;
        for (int diceValue = 6; diceValue >= 1; diceValue--) {
            if (tallies[diceValue - 1] >= 2) {
                numberOfPair++;
                score += diceValue;
            }
        }

        if (numberOfPair == 2)
            return score * 2;
        else
            return 0;
    }
}

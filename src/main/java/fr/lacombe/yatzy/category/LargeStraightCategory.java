package fr.lacombe.yatzy.category;

import fr.lacombe.yatzy.Roll;
import fr.lacombe.yatzy.ScoreCompute;

public class LargeStraightCategory implements ScoreCompute {

    public int score(Roll roll) {
        int[] tallies = roll.occurrenceOfEachValue();
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1) {
            return 20;
        }
        return 0;
    }
}

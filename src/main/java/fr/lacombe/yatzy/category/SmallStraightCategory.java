package fr.lacombe.yatzy.category;

import fr.lacombe.yatzy.Roll;
import fr.lacombe.yatzy.ScoreCompute;

public class SmallStraightCategory implements ScoreCompute {

    public int score(Roll roll) {
        int[] tallies = roll.occurrenceOfEachValue();
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1) {
            return 15;
        }
        return 0;
    }
}

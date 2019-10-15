package fr.lacombe.yatzy.category;

import fr.lacombe.yatzy.Roll;
import fr.lacombe.yatzy.ScoreCompute;

public class FullHouseCategory implements ScoreCompute {

    public int score(Roll roll) {
        int total = 0;
        int[] tallies = roll.occurrenceOfEachValue();
        if (roll.isTwoOfAKind(tallies) && roll.isThreeOfAKind(tallies)) {
            total = roll.sumDiceValue();
        }
        return total;
    }
}

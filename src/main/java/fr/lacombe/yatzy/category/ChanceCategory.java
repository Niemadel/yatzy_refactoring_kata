package fr.lacombe.yatzy.category;

import fr.lacombe.yatzy.Roll;
import fr.lacombe.yatzy.ScoreCompute;

public class ChanceCategory implements ScoreCompute {

    public int score(Roll roll) {
        return roll.sumDiceValue();
    }
}

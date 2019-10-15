package fr.lacombe.yatzy.category;

import fr.lacombe.yatzy.Dice;
import fr.lacombe.yatzy.Roll;
import fr.lacombe.yatzy.ScoreCompute;

public class SameValueCategory implements ScoreCompute {

    private Dice dice;

    public SameValueCategory(Dice dice) {
        this.dice = dice;
    }

    public int score(Roll roll) {
        return roll.sumDiceWithSameValue(dice.getValue());
    }
}

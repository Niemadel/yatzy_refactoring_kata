package fr.lacombe.yatzy.category;

import fr.lacombe.yatzy.Roll;
import fr.lacombe.yatzy.ScoreCompute;

public class YatzyCategory implements ScoreCompute {

    private static final int IS_YATZY_SCORE = 50;

    public int score(Roll roll) {
        for (int i = 0; i < roll.roll.length - 1; i++)
            if (roll.roll[i] != roll.roll[i + 1]) {
                return 0;
            }
        return IS_YATZY_SCORE;
    }
}

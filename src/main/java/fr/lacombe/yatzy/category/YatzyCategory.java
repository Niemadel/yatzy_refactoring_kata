package fr.lacombe.yatzy.category;

import fr.lacombe.yatzy.Roll;
import fr.lacombe.yatzy.ScoreCompute;

public class YatzyCategory implements ScoreCompute {

    public int score(Roll roll) {
        for (int i = 0; i < roll.game.length - 1; i++)
            if (roll.game[i] != roll.game[i + 1]) {
                return 0;
            }
        return 50;
    }
}

public class Yatzy {

    private static final int TOTAL_DICE_FACES = 6;
    private static final int IS_YATZY_SCORE = 50;
    private static final int SMALL_STRAIGHT_SCORE = 15;
    private static final int LARGE_STRAIGHT_SCORE = 20;
    private int[] roll;

    public Yatzy(int dice1, int dice2, int dice3, int dice4, int dice5) {
        roll = new int[5];
        roll[0] = dice1;
        roll[1] = dice2;
        roll[2] = dice3;
        roll[3] = dice4;
        roll[4] = dice5;
    }

    public int chance() {
        return sumDiceValue();
    }

    private int sumDiceValue() {
        int total = 0;
        for (int dice : roll)
            total += dice;
        return total;
    }

    public int allDiceHaveSameValue() {
        for (int i = 0; i < roll.length - 1; i++)
            if (roll[i] != roll[i + 1]) {
                return 0;
            }
        return IS_YATZY_SCORE;
    }

    private int[] diceValueCounter(int[] roll) {
        int[] tallies = new int[TOTAL_DICE_FACES];
        for (int dice : roll)
            tallies[dice - 1]++;
        return tallies;
    }

    public int ones() {
        return sumDiceWithSameValue(1);
    }

    public int twos() {
        return sumDiceWithSameValue(2);
    }

    public int threes() {
        return sumDiceWithSameValue(3);
    }

    public int fours() {
        return sumDiceWithSameValue(4);
    }

    public int fives() {
        return sumDiceWithSameValue(5);
    }

    public int sixes() {
        return sumDiceWithSameValue(6);
    }

    public int onePair() {
        int[] tallies = diceValueCounter(roll);
        for (int diceValue = TOTAL_DICE_FACES; diceValue >= 1; diceValue--)
            if (tallies[diceValue - 1] >= 2)
                return (diceValue) * 2;
        return 0;
    }

    public int twoPair() {
        int[] tallies = diceValueCounter(roll);
        int numberOfPair = 0;
        int score = 0;
        for (int diceValue = TOTAL_DICE_FACES; diceValue >= 1; diceValue--)
            if (tallies[diceValue - 1] >= 2) {
                numberOfPair++;
                score += diceValue;
            }
        if (numberOfPair == 2)
            return score * 2;
        else
            return 0;
    }

    public int threeOfAKind() {
        int[] tallies = diceValueCounter(roll);
        for (int diceValue = TOTAL_DICE_FACES; diceValue >= 1; diceValue--)
            if (tallies[diceValue - 1] >= 3)
                return (diceValue) * 3;
        return 0;
    }

    public int fourOfAKind() {
        int[] tallies = diceValueCounter(roll);
        for (int diceValue = TOTAL_DICE_FACES; diceValue >= 1; diceValue--)
            if (tallies[diceValue - 1] >= 4)
                return (diceValue) * 4;
        return 0;
    }

    private int sumDiceWithSameValue(int diceValue) {
        int total = 0;
        for (int dice : roll)
            if (dice == diceValue)
                total += diceValue;
        return total;
    }

    public int smallStraight() {
        int[] tallies = diceValueCounter(roll);
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return SMALL_STRAIGHT_SCORE;
        return 0;
    }

    public int largeStraight() {
        int[] tallies = diceValueCounter(roll);
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return LARGE_STRAIGHT_SCORE;
        return 0;
    }

    public int fullHouse() {
        int total = 0;
        int[] tallies = diceValueCounter(roll);
        if (isTwoOfAKind(tallies) && isThreeOfAKind(tallies)) {
            total = sumDiceValue();
        }
        return total;
    }

    private boolean isThreeOfAKind(int[] tallies) {
        boolean isThreeOfAKind = false;
        for (int i = 0; i < 6; i++) {
            if (tallies[i] == 3) {
                isThreeOfAKind = true;
            }
        }
        return isThreeOfAKind;
    }

    private boolean isTwoOfAKind(int[] tallies) {
        boolean isTwoOfAKind = false;
        for (int i = 0; i < 6; i++) {
            if (tallies[i] == 2) {
                isTwoOfAKind = true;
            }
        }
        return isTwoOfAKind;
    }

}

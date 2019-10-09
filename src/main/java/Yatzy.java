public class Yatzy {

    public static final int TOTAL_DICE_FACES = 6;
    private int[] roll;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        roll = new int[5];
        roll[0] = d1;
        roll[1] = d2;
        roll[2] = d3;
        roll[3] = d4;
        roll[4] = d5;
    }

    public int chance() {
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
        return 50;
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

    private boolean isPair(int[] tallies) {
        for (int diceValue = TOTAL_DICE_FACES; diceValue >= 1; diceValue--)
            if (tallies[diceValue - 1] >= 2)
                return true;
        return false;
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
        int sum = 0;
        for (int dice : roll)
            if (dice == diceValue)
                sum += diceValue;
        return sum;
    }

    public int smallStraight() {
        int[] tallies = diceValueCounter(roll);
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    public int largeStraight() {
        int[] tallies = diceValueCounter(roll);
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1 &&
                tallies[5] == 1)
            return 20;
        return 0;
    }

    public int fullHouse() {
        int total = 0;
        int[] tallies = diceValueCounter(roll);

        for (int diceValue = TOTAL_DICE_FACES; diceValue >= 1; diceValue--) {
            if (tallies[diceValue - 1] >= 2) {

                for (diceValue = TOTAL_DICE_FACES; diceValue >= 1; diceValue--) {
                    if (tallies[diceValue - 1] >= 3) {

                        for (int dice : roll)
                            total += dice;
                        return total;
                    }
                }
            }
        }
        return total;
    }

}

public class Yatzy {

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

    public static int allDiceHaveSameValue(int... dice) {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die - 1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public int threeOfAKind() {
        int[] tallies = diceValueCounter(roll);

        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    private int[] diceValueCounter(int[] roll) {
        int[] tallies = new int[6];
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
        for (int i = 0; i != 6; i++)
            if (tallies[6 - i - 1] >= 2)
                return (6 - i) * 2;
        return 0;
    }

    public int fourOfAKind() {
        int[] tallies = diceValueCounter(roll);
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    public int twoPair() {
        int[] tallies = diceValueCounter(roll);
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (tallies[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        if (n == 2)
            return score * 2;
        else
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
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public int fullHouse() {
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        int[] tallies = diceValueCounter(roll);

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }

}

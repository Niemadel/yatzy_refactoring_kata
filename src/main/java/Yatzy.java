public class Yatzy {

    private static final int TOTAL_DICE_FACES = 6;
    public int[] roll;

    public Yatzy(int dice1, int dice2, int dice3, int dice4, int dice5) {
        roll = new int[5];
        roll[0] = dice1;
        roll[1] = dice2;
        roll[2] = dice3;
        roll[3] = dice4;
        roll[4] = dice5;
    }

    public int sumDiceValueInARoll() {
        int total = 0;
        for (int dice : roll)
            total += dice;
        return total;
    }

    public int[] occurenceOfEachValueInARoll() {
        int[] tallies = new int[TOTAL_DICE_FACES];
        for (int dice : roll)
            tallies[dice - 1]++;
        return tallies;
    }


    public int sumDiceWithSameValue(int diceValue) {
        int total = 0;
        for (int dice : roll)
            if (dice == diceValue)
                total += diceValue;
        return total;
    }

    public boolean isThreeOfAKind(int[] tallies) {
        boolean isThreeOfAKind = false;
        for (int i = 0; i < 6; i++) {
            if (tallies[i] == 3) {
                isThreeOfAKind = true;
            }
        }
        return isThreeOfAKind;
    }

    public boolean isTwoOfAKind(int[] tallies) {
        boolean isTwoOfAKind = false;
        for (int i = 0; i < 6; i++) {
            if (tallies[i] == 2) {
                isTwoOfAKind = true;
            }
        }
        return isTwoOfAKind;
    }

}

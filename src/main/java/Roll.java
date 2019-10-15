public class Roll {

    private static final int TOTAL_DICE_FACES = 6;
    public static final int THREE_OCCURRENCE = 3;
    public static final int TWO_OCCURRENCE = 2;
    public Dice[] roll;

    public Roll(Dice dice1, Dice dice2, Dice dice3, Dice dice4, Dice dice5) {
        roll = new Dice[5];
        roll[0] = dice1;
        roll[1] = dice2;
        roll[2] = dice3;
        roll[3] = dice4;
        roll[4] = dice5;
    }

    public int sumDiceValueInARoll() {
        int total = 0;
        for (Dice dice : roll)
            total += dice.getValue();
        return total;
    }

    public int[] occurrenceOfEachValueInARoll() {
        int[] tallies = new int[TOTAL_DICE_FACES];
        for (Dice dice : roll)
            tallies[dice.getValue() - 1]++;
        return tallies;
    }


    public int sumDiceWithSameValue(int diceValue) {
        int total = 0;
        for (Dice dice : roll)
            if (dice.getValue() == diceValue)
                total += diceValue;
        return total;
    }

    public boolean isThreeOfAKind(int[] tallies) {
        boolean isThreeOfAKind = false;
        for (int diceValue = TOTAL_DICE_FACES; diceValue >= 1; diceValue--) {
            if (tallies[diceValue] == THREE_OCCURRENCE) {
                isThreeOfAKind = true;
            }
        }
        return isThreeOfAKind;
    }

    public boolean isTwoOfAKind(int[] tallies) {
        boolean isTwoOfAKind = false;
        for (int diceValue = TOTAL_DICE_FACES; diceValue >= 1; diceValue--) {
            if (tallies[diceValue] == TWO_OCCURRENCE) {
                isTwoOfAKind = true;
            }
        }
        return isTwoOfAKind;
    }
}

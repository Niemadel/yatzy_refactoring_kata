public class Score {

    private static final int SMALL_STRAIGHT_SCORE = 15;
    private static final int LARGE_STRAIGHT_SCORE = 20;
    private static final int IS_YATZY_SCORE = 50;
    private static final int TOTAL_DICE_FACES = 6;

    public int allDiceHaveSameValue(Roll roll) {
        for (int i = 0; i < roll.roll.length - 1; i++)
            if (roll.roll[i] != roll.roll[i + 1]) {
                return 0;
            }
        return IS_YATZY_SCORE;
    }

    public int chance(Roll roll) {
        return roll.sumDiceValueInARoll();
    }

    public int ones(Roll roll) {
        return roll.sumDiceWithSameValue(1);
    }

    public int twos(Roll roll) {
        return roll.sumDiceWithSameValue(2);
    }

    public int threes(Roll roll) {
        return roll.sumDiceWithSameValue(3);
    }

    public int fours(Roll roll) {
        return roll.sumDiceWithSameValue(4);
    }

    public int fives(Roll roll) {
        return roll.sumDiceWithSameValue(5);
    }

    public int sixes(Roll roll) {
        return roll.sumDiceWithSameValue(6);
    }

    public int onePair(Roll roll) {
        int[] tallies = roll.occurrenceOfEachValueInARoll();
        for (int diceValue = TOTAL_DICE_FACES; diceValue >= 1; diceValue--)
            if (tallies[diceValue - 1] >= 2)
                return (diceValue) * 2;
        return 0;
    }

    public int twoPair(Roll roll) {
        int[] tallies = roll.occurrenceOfEachValueInARoll();
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

    public int threeOfAKind(Roll roll) {
        int[] tallies = roll.occurrenceOfEachValueInARoll();
        for (int diceValue = TOTAL_DICE_FACES; diceValue >= 1; diceValue--)
            if (tallies[diceValue - 1] >= 3)
                return (diceValue) * 3;
        return 0;
    }

    public int fourOfAKind(Roll roll) {
        int[] tallies = roll.occurrenceOfEachValueInARoll();
        for (int diceValue = TOTAL_DICE_FACES; diceValue >= 1; diceValue--)
            if (tallies[diceValue - 1] >= 4)
                return (diceValue) * 4;
        return 0;
    }

    public int smallStraight(Roll roll) {
        int[] tallies = roll.occurrenceOfEachValueInARoll();
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return SMALL_STRAIGHT_SCORE;
        return 0;
    }

    public int largeStraight(Roll roll) {
        int[] tallies = roll.occurrenceOfEachValueInARoll();
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return LARGE_STRAIGHT_SCORE;
        return 0;
    }

    public int fullHouse(Roll roll) {
        int total = 0;
        int[] tallies = roll.occurrenceOfEachValueInARoll();
        if (roll.isTwoOfAKind(tallies) && roll.isThreeOfAKind(tallies)) {
            total = roll.sumDiceValueInARoll();
        }
        return total;
    }
}

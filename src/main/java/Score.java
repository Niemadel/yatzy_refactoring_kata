public class Score {

    private static final int SMALL_STRAIGHT_SCORE = 15;
    private static final int LARGE_STRAIGHT_SCORE = 20;
    private static final int IS_YATZY_SCORE = 50;
    private static final int TOTAL_DICE_FACES = 6;

    public int allDiceHaveSameValue(Yatzy yatzy) {
        for (int i = 0; i < yatzy.roll.length - 1; i++)
            if (yatzy.roll[i] != yatzy.roll[i + 1]) {
                return 0;
            }
        return IS_YATZY_SCORE;
    }

    public int chance(Yatzy yatzy) {
        return yatzy.sumDiceValueInARoll();
    }

    public int ones(Yatzy yatzy) {
        return yatzy.sumDiceWithSameValue(1);
    }

    public int twos(Yatzy yatzy) {
        return yatzy.sumDiceWithSameValue(2);
    }

    public int threes(Yatzy yatzy) {
        return yatzy.sumDiceWithSameValue(3);
    }

    public int fours(Yatzy yatzy) {
        return yatzy.sumDiceWithSameValue(4);
    }

    public int fives(Yatzy yatzy) {
        return yatzy.sumDiceWithSameValue(5);
    }

    public int sixes(Yatzy yatzy) {
        return yatzy.sumDiceWithSameValue(6);
    }

    public int onePair(Yatzy yatzy) {
        int[] tallies = yatzy.occurenceOfEachValueInARoll();
        for (int diceValue = TOTAL_DICE_FACES; diceValue >= 1; diceValue--)
            if (tallies[diceValue - 1] >= 2)
                return (diceValue) * 2;
        return 0;
    }

    public int twoPair(Yatzy yatzy) {
        int[] tallies = yatzy.occurenceOfEachValueInARoll();
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

    public int threeOfAKind(Yatzy yatzy) {
        int[] tallies = yatzy.occurenceOfEachValueInARoll();
        for (int diceValue = TOTAL_DICE_FACES; diceValue >= 1; diceValue--)
            if (tallies[diceValue - 1] >= 3)
                return (diceValue) * 3;
        return 0;
    }

    public int fourOfAKind(Yatzy yatzy) {
        int[] tallies = yatzy.occurenceOfEachValueInARoll();
        for (int diceValue = TOTAL_DICE_FACES; diceValue >= 1; diceValue--)
            if (tallies[diceValue - 1] >= 4)
                return (diceValue) * 4;
        return 0;
    }

    public int smallStraight(Yatzy yatzy) {
        int[] tallies = yatzy.occurenceOfEachValueInARoll();
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return SMALL_STRAIGHT_SCORE;
        return 0;
    }

    public int largeStraight(Yatzy yatzy) {
        int[] tallies = yatzy.occurenceOfEachValueInARoll();
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return LARGE_STRAIGHT_SCORE;
        return 0;
    }

    public int fullHouse(Yatzy yatzy) {
        int total = 0;
        int[] tallies = yatzy.occurenceOfEachValueInARoll();
        if (yatzy.isTwoOfAKind(tallies) && yatzy.isThreeOfAKind(tallies)) {
            total = yatzy.sumDiceValueInARoll();
        }
        return total;
    }
}

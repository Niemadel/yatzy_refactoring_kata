import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    Score score = new Score();
    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, score.chance(new Yatzy(2, 3, 4, 5, 1)));
        assertEquals(16, score.chance(new Yatzy(3, 3, 4, 5, 1)));
    }

    @Test
    public void yatzy_scores_50_if_all_dice_have_same_value() {
        assertEquals(50, score.allDiceHaveSameValue(new Yatzy(4, 4, 4, 4, 4)));
        assertEquals(50, score.allDiceHaveSameValue(new Yatzy(6, 6, 6, 6, 6)));
        assertEquals(0, score.allDiceHaveSameValue(new Yatzy(6, 6, 6, 6, 3)));
    }

    @Test
    public void ones_scores_sum_of_dice_value_one() {
        assertEquals(5, score.ones(new Yatzy(1, 1, 1, 1, 1)));
        assertEquals(2, score.ones(new Yatzy(4, 1, 3, 1, 6)));
    }

    @Test
    public void twos_scores_sum_of_dice_value_two() {
        assertEquals(4, score.twos(new Yatzy(1, 2, 1, 4, 2)));
        assertEquals(6, score.twos(new Yatzy(2, 1, 2, 1, 2)));
    }

    @Test
    public void threes_scores_sum_of_dice_value_three() {
        assertEquals(6, score.threes(new Yatzy(3, 1, 1, 3, 1)));
        assertEquals(12, score.threes(new Yatzy(3, 3, 3, 1, 3)));
    }

    @Test
    public void fours_scores_sum_of_dice_value_four() {
        assertEquals(12, score.fours(new Yatzy(4, 4, 4, 5, 5)));
        assertEquals(8, score.fours(new Yatzy(4, 4, 5, 5, 5)));
        assertEquals(4, score.fours(new Yatzy(4, 5, 5, 5, 5)));
    }

    @Test
    public void fives_scores_sum_of_dice_value_five() {
        assertEquals(10, score.fives(new Yatzy(4, 4, 4, 5, 5)));
        assertEquals(15, score.fives(new Yatzy(4, 4, 5, 5, 5)));
        assertEquals(20, score.fives(new Yatzy(4, 5, 5, 5, 5)));
    }

    @Test
    public void sixes_scores_sum_of_dice_value_six() {
        assertEquals(0, score.sixes(new Yatzy(4, 4, 4, 5, 5)));
        assertEquals(6, score.sixes(new Yatzy(4, 4, 6, 5, 5)));
        assertEquals(18, score.sixes(new Yatzy(6, 5, 6, 6, 5)));
    }

    @Test
    public void one_pair_scores_sum_of_two_highest_matching_dice() {
        assertEquals(6, score.onePair(new Yatzy(3, 4, 3, 5, 6)));
        assertEquals(10, score.onePair(new Yatzy(5, 3, 3, 3, 5)));
        assertEquals(12, score.onePair(new Yatzy(5, 3, 6, 6, 5)));
        assertEquals(4, score.onePair(new Yatzy(1, 1, 6, 2, 2)));
    }

    @Test
    public void two_pair_score_sum_of_two_pair() {
        assertEquals(16, score.twoPair(new Yatzy(3, 3, 5, 4, 5)));
        assertEquals(16, score.twoPair(new Yatzy(3, 3, 5, 5, 5)));
    }

    @Test
    public void three_of_a_kind_scores_sum_of_three_dice_with_same_value() {
        assertEquals(9, score.threeOfAKind(new Yatzy(3, 3, 3, 4, 5)));
        assertEquals(15, score.threeOfAKind(new Yatzy(5, 3, 5, 4, 5)));
        assertEquals(9, score.threeOfAKind(new Yatzy(3, 3, 3, 3, 5)));
    }

    @Test
    public void four_of_a_kind_score_sum_of_four_dice_with_same_value() {
        assertEquals(12, score.fourOfAKind(new Yatzy(3, 3, 3, 3, 5)));
        assertEquals(20, score.fourOfAKind(new Yatzy(5, 5, 5, 4, 5)));
        assertEquals(12, score.fourOfAKind(new Yatzy(3, 3, 3, 3, 3)));
    }

    @Test
    public void smallStraight_scores_15_if_roll_is_12345() {
        assertEquals(15, score.smallStraight(new Yatzy(1, 2, 3, 4, 5)));
        assertEquals(15, score.smallStraight(new Yatzy(2, 3, 4, 5, 1)));
        assertEquals(0, score.smallStraight(new Yatzy(1, 2, 2, 4, 5)));
    }

    @Test
    public void largeStraight_scores_20_if_roll_is_23456() {
        assertEquals(20, score.largeStraight(new Yatzy(6, 2, 3, 4, 5)));
        assertEquals(20, score.largeStraight(new Yatzy(2, 3, 4, 5, 6)));
        assertEquals(0, score.largeStraight(new Yatzy(1, 2, 2, 4, 5)));
    }

    @Test
    public void fullHouse_scores_sum_of_two_of_a_kind_and_three_of_a_kind() {
        assertEquals(18, score.fullHouse(new Yatzy(6, 2, 2, 2, 6)));
        assertEquals(0, score.fullHouse(new Yatzy(2, 3, 4, 5, 6)));
        assertEquals(0, score.fullHouse(new Yatzy(2, 3, 4, 3, 6)));
        assertEquals(0, score.fullHouse(new Yatzy(3, 3, 4, 3, 6)));
    }
}
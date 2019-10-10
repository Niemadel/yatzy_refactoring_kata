import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, new Yatzy(2, 3, 4, 5, 1).chance());
        assertEquals(16, new Yatzy(3, 3, 4, 5, 1).chance());
    }

    @Test
    public void yatzy_scores_50_if_all_dice_have_same_value() {
        assertEquals(50, new Yatzy(4, 4, 4, 4, 4).allDiceHaveSameValue());
        assertEquals(50, new Yatzy(6, 6, 6, 6, 6).allDiceHaveSameValue());
        assertEquals(0, new Yatzy(6, 6, 6, 6, 3).allDiceHaveSameValue());
    }

    @Test
    public void ones_scores_sum_of_dice_value_one() {
        assertEquals(5, new Yatzy(1, 1, 1, 1, 1).ones());
        assertEquals(2, new Yatzy(4, 1, 3, 1, 6).ones());
    }

    @Test
    public void twos_scores_sum_of_dice_value_twos() {
        assertEquals(4, new Yatzy(1, 2, 1, 4, 2).twos());
        assertEquals(6, new Yatzy(2, 1, 2, 1, 2).twos());
    }

    @Test
    public void threes_scores_sum_of_dice_value_three() {
        assertEquals(6, new Yatzy(3, 1, 1, 3, 1).threes());
        assertEquals(12, new Yatzy(3, 3, 3, 1, 3).threes());
    }

    @Test
    public void fours_scores_sum_of_dice_value_four() {
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
    }

    @Test
    public void fives_scores_sum_of_dice_value_five() {
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
        assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
    }

    @Test
    public void sixes_scores_sum_of_dice_value_six() {
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
    }

    @Test
    public void one_pair_scores_sum_of_two_highest_matching_dice() {
        assertEquals(6, new Yatzy(3, 4, 3, 5, 6).onePair());
        assertEquals(10, new Yatzy(5, 3, 3, 3, 5).onePair());
        assertEquals(12, new Yatzy(5, 3, 6, 6, 5).onePair());
        assertEquals(4, new Yatzy(1, 1, 6, 2, 2).onePair());
    }

    @Test
    public void two_pair_score_sum_of_two_pair() {
        assertEquals(16, new Yatzy(3, 3, 5, 4, 5).twoPair());
        assertEquals(16, new Yatzy(3, 3, 5, 5, 5).twoPair());
    }

    @Test
    public void three_of_a_kind_scores_sum_of_three_dice_with_same_value() {
        assertEquals(9, new Yatzy(3, 3, 3, 4, 5).threeOfAKind());
        assertEquals(15, new Yatzy(5, 3, 5, 4, 5).threeOfAKind());
        assertEquals(9, new Yatzy(3, 3, 3, 3, 5).threeOfAKind());
    }

    @Test
    public void four_of_a_kind_score_sum_of_four_dice_with_same_value() {
        assertEquals(12, new Yatzy(3, 3, 3, 3, 5).fourOfAKind());
        assertEquals(20, new Yatzy(5, 5, 5, 4, 5).fourOfAKind());
        assertEquals(12, new Yatzy(3, 3, 3, 3, 3).fourOfAKind());
    }

    @Test
    public void smallStraight_scores_15_if_roll_is_12345() {
        assertEquals(15, new Yatzy(1, 2, 3, 4, 5).smallStraight());
        assertEquals(15, new Yatzy(2, 3, 4, 5, 1).smallStraight());
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).smallStraight());
    }

    @Test
    public void largeStraight_scores_20_if_roll_is_23456() {
        assertEquals(20, new Yatzy(6, 2, 3, 4, 5).largeStraight());
        assertEquals(20, new Yatzy(2, 3, 4, 5, 6).largeStraight());
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).largeStraight());
    }

    @Test
    public void fullHouse_scores_sum_of_two_of_a_kind_and_three_of_a_kind() {
        assertEquals(18, new Yatzy(6, 2, 2, 2, 6).fullHouse());
        assertEquals(0, new Yatzy(2, 3, 4, 5, 6).fullHouse());
        assertEquals(0, new Yatzy(2, 3, 4, 3, 6).fullHouse());
        assertEquals(0, new Yatzy(3, 3, 4, 3, 6).fullHouse());
    }
}
package fr.lacombe.yatzy;

import fr.lacombe.yatzy.category.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RollTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        ChanceCategory chance = new ChanceCategory();

        assertEquals(15, chance.score(new Roll(Dice.TWO, Dice.THREE, Dice.FOUR, Dice.FIVE, Dice.ONE)));
        assertEquals(16, chance.score(new Roll(Dice.THREE, Dice.THREE, Dice.FOUR, Dice.FIVE, Dice.ONE)));
    }

    @Test
    public void yatzy_scores_50_if_all_dice_have_same_value() {
        YatzyCategory yatzy = new YatzyCategory();

        assertEquals(50, yatzy.score(new Roll(Dice.FOUR, Dice.FOUR, Dice.FOUR, Dice.FOUR, Dice.FOUR)));
        assertEquals(50, yatzy.score(new Roll(Dice.SIX, Dice.SIX, Dice.SIX, Dice.SIX, Dice.SIX)));
        assertEquals(0, yatzy.score(new Roll(Dice.SIX, Dice.SIX, Dice.SIX, Dice.SIX, Dice.THREE)));

    }

    @Test
    public void ones_scores_sum_of_dice_value_one() {
        SameValueCategory sameValue = new SameValueCategory(Dice.ONE);

        assertEquals(5, sameValue.score(new Roll(Dice.ONE, Dice.ONE, Dice.ONE, Dice.ONE, Dice.ONE)));
        assertEquals(2, sameValue.score(new Roll(Dice.FOUR, Dice.ONE, Dice.THREE, Dice.ONE, Dice.SIX)));
    }

    @Test
    public void twos_scores_sum_of_dice_value_two() {
        SameValueCategory sameValue = new SameValueCategory(Dice.TWO);

        assertEquals(4, sameValue.score(new Roll(Dice.ONE, Dice.TWO, Dice.ONE, Dice.FOUR, Dice.TWO)));
        assertEquals(6, sameValue.score(new Roll(Dice.TWO, Dice.ONE, Dice.TWO, Dice.ONE, Dice.TWO)));
    }

    @Test
    public void threes_scores_sum_of_dice_value_three() {
        SameValueCategory sameValue = new SameValueCategory(Dice.THREE);

        assertEquals(6, sameValue.score(new Roll(Dice.THREE, Dice.ONE, Dice.ONE, Dice.THREE, Dice.ONE)));
        assertEquals(12, sameValue.score(new Roll(Dice.THREE, Dice.THREE, Dice.THREE, Dice.ONE, Dice.THREE)));
    }

    @Test
    public void fours_scores_sum_of_dice_value_four() {
        SameValueCategory sameValue = new SameValueCategory(Dice.FOUR);

        assertEquals(12, sameValue.score(new Roll(Dice.FOUR, Dice.FOUR, Dice.FOUR, Dice.FIVE, Dice.FIVE)));
        assertEquals(8, sameValue.score(new Roll(Dice.FOUR, Dice.FOUR, Dice.FIVE, Dice.FIVE, Dice.FIVE)));
    }

    @Test
    public void fives_scores_sum_of_dice_value_five() {
        SameValueCategory sameValue = new SameValueCategory(Dice.FIVE);

        assertEquals(10, sameValue.score(new Roll(Dice.FOUR, Dice.FOUR, Dice.FOUR, Dice.FIVE, Dice.FIVE)));
        assertEquals(15, sameValue.score(new Roll(Dice.FOUR, Dice.FOUR, Dice.FIVE, Dice.FIVE, Dice.FIVE)));
    }

    @Test
    public void sixes_scores_sum_of_dice_value_six() {
        SameValueCategory sameValue = new SameValueCategory(Dice.SIX);

        assertEquals(0, sameValue.score(new Roll(Dice.FOUR, Dice.FOUR, Dice.FOUR, Dice.FIVE, Dice.FIVE)));
        assertEquals(6, sameValue.score(new Roll(Dice.FOUR, Dice.FOUR, Dice.SIX, Dice.ONE, Dice.TWO)));
    }

    @Test
    public void one_pair_scores_sum_of_two_highest_matching_dice() {
        OnePairCategory onePairCategory = new OnePairCategory();

        assertEquals(6, onePairCategory.score(new Roll(Dice.THREE, Dice.FOUR, Dice.THREE, Dice.FIVE, Dice.SIX)));
        assertEquals(10, onePairCategory.score(new Roll(Dice.FIVE, Dice.THREE, Dice.THREE, Dice.THREE, Dice.FIVE)));
        assertEquals(12, onePairCategory.score(new Roll(Dice.FIVE, Dice.THREE, Dice.SIX, Dice.SIX, Dice.FIVE)));
        assertEquals(4, onePairCategory.score(new Roll(Dice.ONE, Dice.ONE, Dice.SIX, Dice.TWO, Dice.TWO)));
    }

    @Test
    public void two_pair_score_sum_of_two_pair() {
        TwoPairCategory twoPairCategory = new TwoPairCategory();

        assertEquals(16, twoPairCategory.score(new Roll(Dice.THREE, Dice.THREE, Dice.FIVE, Dice.FOUR, Dice.FIVE)));
        assertEquals(16, twoPairCategory.score(new Roll(Dice.THREE, Dice.THREE, Dice.FIVE, Dice.FIVE, Dice.FIVE)));
    }

    @Test
    public void three_of_a_kind_scores_sum_of_three_dice_with_same_value() {
        ThreeOfAKindCategory threeOfAKindCategory = new ThreeOfAKindCategory();

        assertEquals(9, threeOfAKindCategory.score(new Roll(Dice.THREE, Dice.THREE, Dice.THREE, Dice.FOUR, Dice.FIVE)));
        assertEquals(15, threeOfAKindCategory.score(new Roll(Dice.FIVE, Dice.THREE, Dice.FIVE, Dice.FOUR, Dice.FIVE)));
        assertEquals(9, threeOfAKindCategory.score(new Roll(Dice.THREE, Dice.THREE, Dice.THREE, Dice.THREE, Dice.FIVE)));
    }

    @Test
    public void four_of_a_kind_score_sum_of_four_dice_with_same_value() {
        FourOfAKindCategory fourOfAKindCategory = new FourOfAKindCategory();

        assertEquals(12, fourOfAKindCategory.score(new Roll(Dice.THREE, Dice.THREE, Dice.THREE, Dice.THREE, Dice.FIVE)));
        assertEquals(20, fourOfAKindCategory.score(new Roll(Dice.FIVE, Dice.FIVE, Dice.FIVE, Dice.FOUR, Dice.FIVE)));
        assertEquals(12, fourOfAKindCategory.score(new Roll(Dice.THREE, Dice.THREE, Dice.THREE, Dice.THREE, Dice.THREE)));
    }

    @Test
    public void smallStraight_scores_15_if_roll_is_12345() {
        SmallStraightCategory smallStraightCategory = new SmallStraightCategory();

        assertEquals(15, smallStraightCategory.score(new Roll(Dice.ONE, Dice.TWO, Dice.THREE, Dice.FOUR, Dice.FIVE)));
        assertEquals(15, smallStraightCategory.score(new Roll(Dice.TWO, Dice.THREE, Dice.FOUR, Dice.FIVE, Dice.ONE)));
        assertEquals(0, smallStraightCategory.score(new Roll(Dice.ONE, Dice.TWO, Dice.TWO, Dice.FOUR, Dice.FIVE)));
    }

    @Test
    public void largeStraight_scores_20_if_roll_is_23456() {
        LargeStraightCategory largeStraightCategory = new LargeStraightCategory();

        assertEquals(20, largeStraightCategory.score(new Roll(Dice.SIX, Dice.TWO, Dice.THREE, Dice.FOUR, Dice.FIVE)));
        assertEquals(20, largeStraightCategory.score(new Roll(Dice.TWO, Dice.THREE, Dice.FOUR, Dice.FIVE, Dice.SIX)));
        assertEquals(0, largeStraightCategory.score(new Roll(Dice.ONE, Dice.TWO, Dice.TWO, Dice.FOUR, Dice.FIVE)));
    }

    @Test
    public void fullHouse_scores_sum_of_two_of_a_kind_and_three_of_a_kind() {
        FullHouseCategory fullHouseCategory = new FullHouseCategory();

        assertEquals(18, fullHouseCategory.score(new Roll(Dice.SIX, Dice.TWO, Dice.TWO, Dice.TWO, Dice.SIX)));
        assertEquals(0, fullHouseCategory.score(new Roll(Dice.TWO, Dice.THREE, Dice.FOUR, Dice.FIVE, Dice.SIX)));
        assertEquals(0, fullHouseCategory.score(new Roll(Dice.TWO, Dice.THREE, Dice.FOUR, Dice.THREE, Dice.SIX)));
        assertEquals(0, fullHouseCategory.score(new Roll(Dice.THREE, Dice.THREE, Dice.FOUR, Dice.THREE, Dice.SIX)));

    }

}
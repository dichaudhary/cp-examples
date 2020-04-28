package practie.cp.fun.dp;

import org.junit.Assert;
import org.junit.Test;
import practice.cp.fun.dp.KnapsackNoRepetition;

public class TestKnapsackNoRepetition {

    @Test
    public void testKnapsack() {
        KnapsackNoRepetition knapsackNoRepetition = new KnapsackNoRepetition(new int[] {1, 5, 3, 9}, new int[] {4, 3, 5, 7}, 10);
        Assert.assertEquals(knapsackNoRepetition.solveKnapsack(), 10);
    }
}

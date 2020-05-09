/*Suppose you have N eggs and you want to determine from which floor in a K-floor building you can drop an egg such that it doesn't break.
 You have to determine the minimum number of attempts you need in order find the critical floor in the worst case while using the best strategy.
 There are few rules given below.

    An egg that survives a fall can be used again.
    A broken egg must be discarded.
    The effect of a fall is the same for all eggs.
    If the egg doesn't break at a certain floor, it will not break at any floor below.
    If the eggs breaks at a certain floor, it will break at any floor above.
    */

package practice.cp.fun.recursion;

public class EggProblem {
    public int nEggs;
    public int kFloors;
    public int min = Integer.MAX_VALUE;

    public EggProblem(int nEggs, int kFloors) {
        this.nEggs = nEggs;
        this.kFloors = kFloors;
    }

    public int findEggNonBreakingFloorRecursive() {
        return findEggNonBreakingFloorUtil(nEggs, kFloors);
    }

    private int findEggNonBreakingFloorUtil(int nEggs, int kFloors) {
        if (kFloors == 0 || kFloors == 1) {
            return kFloors;
        }
        if (nEggs == 1) {
            return kFloors;
        }
        for (int i=1; i<=kFloors; i++) {
            min = Math.min(min, 1 + Math.max(findEggNonBreakingFloorUtil(nEggs -1, i -1), findEggNonBreakingFloorUtil(nEggs, kFloors- i)));
        }
        return min;
    }
}

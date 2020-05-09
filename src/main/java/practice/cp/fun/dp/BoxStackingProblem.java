package practice.cp.fun.dp;
/*You are given a set of n types of rectangular 3-D boxes, where the i^th box has height h(i), width w(i) and depth d(i) (all real numbers).
 You want to create a stack of boxes which is as tall as possible, but you can only stack a box on top of another box if the dimensions of the 2-D base of the lower box are each strictly larger than those of the 2-D base of the higher box.
 Of course, you can rotate a box so that any side functions as its base.
 It is also allowable to use multiple instances of the same type of box.*/

import java.util.Arrays;

public class BoxStackingProblem {
    public Box[] arr;
    public int n;
    Box[] rot;
    int[] dp;

    public BoxStackingProblem(Box[] arr) {
        this.arr = arr;
        this.n = this.arr.length;
        rot = new Box[6*n];
        for (int i=0;i<n;i++) {
            Box box = arr[i];
            rot[i*6 + 0] = new Box(box.w, box.h, box.l);
            rot[i*6 + 1] = new Box(box.w, box.l, box.h);
            rot[i*6 + 2] = new Box(box.l, box.w, box.h);
            rot[i*6 + 3] = new Box(box.l, box.h, box.w);
            rot[i*6 + 4] = new Box(box.h, box.w, box.l);
            rot[i*6 + 5] = new Box(box.h, box.l, box.w);
        }
        Arrays.sort(rot);
        dp = new int[6*n];
        for (int i=0; i<6*n;i++) {
            dp[i] = rot[i].h;
        }
    }
    public int getMaxHeight() {
        for (int i=1;i<6*n;i++) {
            int val = 0;
            for (int j=0; j<i; j++ ) {
                Box boxi = rot[i];
                Box boxj = rot[j];
                if (boxj.w>boxi.w && boxj.l>boxi.l && dp[i] < dp[j] + boxi.h) {
                    dp[i] = dp[j] + boxi.h;
                }
            }
        }
        int max = -1;

        /* Pick maximum of all msh values */
        for(int i = 0; i < 6*n; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}



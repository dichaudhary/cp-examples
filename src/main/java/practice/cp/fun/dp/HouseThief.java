package practice.cp.fun.dp;

class HouseThief {

    public int findMaxSteal(int[] wealth) {
        if(wealth.length == 0) return 0;
        int n1=wealth[0], n2=wealth[1], temp;
        for(int i=2; i < wealth.length; i++) {
            temp = Math.max(n1 + wealth[i], n2);
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }

    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxSteal(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxSteal(wealth));
    }
}
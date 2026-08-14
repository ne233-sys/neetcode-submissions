class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 2) return Math.min(cost[0], cost[1]);

        int[] a = new int[n];

        for(int i = 2; i < n; i++) a[i] = Math.min(a[i - 2] + cost[i - 2], a[i - 1] + cost[i - 1]);

        return Math.min(a[n - 2] + cost[n - 2], a[n - 1] + cost[n - 1]);
    }
}

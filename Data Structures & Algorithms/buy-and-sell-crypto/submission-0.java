class Solution {
    public int maxProfit(int[] prices) {
        int minval = prices[0], back = 0, front = 1, dif = 0, max = 0;

        while(front < prices.length){
            dif = prices[front] - prices[back];
            if(dif > max) max = dif;

            if(prices[front] < prices[back]){
                back = front;
                front++;
            }
            else front++;
        }

        if(max < 0) return 0;
        else return max;
    }
}

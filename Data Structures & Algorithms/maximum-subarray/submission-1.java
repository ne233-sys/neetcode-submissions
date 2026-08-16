class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];

        int max = Integer.MIN_VALUE, total = 0;

        for(int i = 0; i < nums.length; i++){
            total += nums[i];
            if(total > max) max = total;
            if(total < 0) total = 0;
        }

        return max;
    }
}

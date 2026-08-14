class Solution {
    public int rob(int[] nums) {
        int n = nums.length, max;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        if(n == 3) return Math.max(nums[0] + nums[2], nums[1]);

        int[] arr = new int[n];
        arr[2] = Math.max(nums[0] + nums[2], nums[1]);
        max = arr[2];
        arr[0] = nums[0];
        arr[1] = nums[1];

        for(int i = 3; i < n; i++) {
            arr[i] = Math.max(arr[i-3] + nums[i], arr[i-2] + nums[i]);
            if(arr[i] > max) max = arr[i];
        }

        return max;
    }
}

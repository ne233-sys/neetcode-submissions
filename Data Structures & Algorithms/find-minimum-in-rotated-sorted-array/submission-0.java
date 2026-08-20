class Solution {
    public int findMin(int[] nums) {
        if(nums[0] < nums[nums.length - 1]) return nums[0];

        int left = 0, right = nums.length - 1;

        while(left + 1 < right){
            int middle = left + (right - left) / 2;

            if(nums[middle] > nums[right]) left = middle;
            else right = middle;
        }

        return Math.min(nums[left], nums[right]);
    }
}

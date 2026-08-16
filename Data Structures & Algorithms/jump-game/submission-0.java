class Solution {
    public boolean canJump(int[] nums) {
        int furthest = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(i <= furthest && furthest < nums[i] + i) furthest = nums[i] + i;
            else if(i > furthest) return false;
        }

        return true;
    }
}

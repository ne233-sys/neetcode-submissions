class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        if(nums[0] >= nums.length - 1) return 1;
        
        int jumps = 1, furthest1 = nums[0], furthest2 = nums[0];

        for(int i = 1; i < nums.length - 1; i++){
            if(i > furthest1){
                furthest1 = furthest2;
                jumps++;
            }
            if(i <= furthest1){
                if(i + nums[i] > furthest2) furthest2 = i + nums[i];
                if(furthest2 >= nums.length - 1) return jumps + 1;
            }           
        }

        return jumps;
    }
}

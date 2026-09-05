class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0, last = nums.length - 1;
        for(int i = 0; i < nums.length - count; i++){
            if(nums[last - count] == val){
                count++;
                i--;
                continue;
            }

            if(nums[i] == val){
                int temp = nums[i];
                nums[i] = nums[last - count];
                nums[last - count] = temp;
                count++;
            }
        }

        return nums.length - count;
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length, mp = 1;
        int[] result = new int[length];

        for(int i = 0; i < length; i++){
            result[i] = mp;
            mp *= nums[i];
        }
        mp = 1;

        for(int i = length - 1; i >= 0; i--){
            result[i] *= mp;
            mp *= nums[i];
        }

        return result;
    }
}  

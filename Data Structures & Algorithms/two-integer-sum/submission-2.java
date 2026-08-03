class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int temp;
        HashMap<Integer, Integer> set = new HashMap<>(nums.length);

        for(int i = 0; i < nums.length; i++){
            temp = target - nums[i];

            if(set.containsKey(nums[i])){
                temp = set.get(nums[i]);
                result[0] = temp;
                result[1] = i;

                if(i < temp){
                    temp = result[1];
                    result[1] = result[0];
                    result[0] = temp;
                }
                break;
            }
            set.put(temp, i);
        }
        return result;
    }
}

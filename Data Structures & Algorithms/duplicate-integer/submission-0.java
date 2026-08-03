class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> a = new HashSet<>(nums.length);

        for(int i = 0; i < nums.length; i++){
            if(a.contains(nums[i])) return true;
            else a.add(nums[i]);
        }
        return false;
    }
}
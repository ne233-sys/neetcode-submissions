class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        rec(nums, new ArrayList<>(), 0);
        return result;
    }

    private void rec(int[] nums, List<Integer> subset, int level) {
        if(level == nums.length) result.add(subset);
        else {
            List<Integer> copy1 = new ArrayList<>(subset);
            rec(nums, copy1, level + 1);

            List<Integer> copy2 = new ArrayList<>(subset);
            copy2.add(nums[level]);
            rec(nums, copy2, level + 1);
        }
    }
}

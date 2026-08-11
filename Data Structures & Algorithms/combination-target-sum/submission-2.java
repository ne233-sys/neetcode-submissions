class Solution {
    private List<List<Integer>> result;
    private int[] nums;
    private int target;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        this.nums = nums;
        this.target = target;

        List<Integer> subset = new ArrayList<>();
        rec(subset, 0, 0);

        return result;
    }

    private void rec(List<Integer> subset, int sum, int i) {
        if(sum < target) {
            subset.add(nums[i]);

            if(sum + nums[i] <= target) rec(subset, sum + nums[i], i);
            subset.removeLast();

            if(i + 1 < nums.length) rec(subset, sum, i + 1);
        }
        else if(sum == target) result.add(new ArrayList<>(subset));
    }
}

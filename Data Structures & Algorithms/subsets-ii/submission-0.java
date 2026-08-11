class Solution {
    private List<List<Integer>> result;
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        result = new ArrayList<>();

        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<>();

        rec(0, subset);
        return result;
    }

    private void rec(int i, List<Integer> subset) {
        if(i < nums.length) {
            subset.add(nums[i]);
            rec(i + 1, subset);
            subset.removeLast();

            while(i < nums.length - 1 && nums[i] == nums[i + 1]) i++;

            rec(i + 1, subset);           
        }
        else if(i == nums.length) {
            result.add(new ArrayList<>(subset));
        }
    }
}

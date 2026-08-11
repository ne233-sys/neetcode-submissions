class Solution {
    private int[] nums;
    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> subset = new ArrayList<>();

        rec(0, subset, set);
        return result;
    }

    private void rec(int i, List<Integer> subset, Set<Integer> set) {
        if(i < nums.length){
            for(int n : nums) if(!set.contains(n)) {
                set.add(n);
                subset.add(n);
                rec(i + 1, subset, set);
                set.remove(n);
                subset.removeLast();
            }
        }
        else if(i == nums.length) result.add(new ArrayList<>(subset));
    }
}

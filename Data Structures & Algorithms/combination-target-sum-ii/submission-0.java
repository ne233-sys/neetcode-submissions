class Solution {
    private List<List<Integer>> result;
    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(candidates); // n*logn is much faster than the rest of the program

        rec(0, 0, subset);
        return result;
    }

    private void rec(int i, int sum, List<Integer> subset) {
        if(sum < target && i < candidates.length) {
            subset.add(candidates[i]);
            rec(i + 1, sum + candidates[i], subset);
            subset.removeLast();

            while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]) i++; //skipping the rest of duplicate candidates

            rec(i + 1, sum, subset);
        }
        else if(sum == target) {
            result.add(new ArrayList<>(subset));
        }
    }
}

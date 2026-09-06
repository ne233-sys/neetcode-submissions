class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        this.result = new LinkedList<>();

        dtree(new LinkedList<>(), n - k, 1, n);

        return result;
    }

    private void dtree(List<Integer> list, int miss, int step, int n) {
        if(step + miss <= n){
            if(miss > 0) dtree(list, miss - 1, step + 1, n);

            list.add(step);
            dtree(list, miss, step + 1, n);
            list.removeLast();
        }
        else result.add(new LinkedList<>(list));
    }
}
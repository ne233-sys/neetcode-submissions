class Solution {
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();

        String subset = "";

        rec(0, 0, n, subset);
        return result;
    }

    private void rec(int i, int allowed, int n, String subset) {
        if(i == n && allowed == 0) result.add(new String(subset));
        else {
            if(i < n){
                subset += "(";
                rec(i + 1, allowed + 1, n, subset);
                subset = subset.substring(0, subset.length() - 1);
            }
            
            if(allowed > 0) {
                subset += ")";
                rec(i, allowed - 1, n, subset);
            }
        }     
    }
}

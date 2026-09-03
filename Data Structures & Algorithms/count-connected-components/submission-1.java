class Solution {
    private Set<Integer> set;
    private Map<Integer, List<Integer>> map;

    public int countComponents(int n, int[][] edges) {
        this.set = new HashSet<>();
        this.map = new HashMap<>();
        int result = 0;

        for(int[] pair : edges){
            if(!map.containsKey(pair[0])) map.put(pair[0], new ArrayList());
            if(!map.containsKey(pair[1])) map.put(pair[1], new ArrayList());

            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }

        for(int i = 0; i < n; i++) if(!set.contains(i)){
            if(map.containsKey(i)) dfs(i);
            result++;
        }

        return result;
    }

    private void dfs(int curr) {
        set.add(curr);

        for(int next : map.get(curr)) if(!set.contains(next)) dfs(next);
    }
}

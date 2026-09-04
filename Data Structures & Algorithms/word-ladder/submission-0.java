class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        boolean present = false;
        Map<String, List<String>> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        Queue<Integer> time = new LinkedList<>();
        que.add(beginWord);
        time.add(1);

        for(String curr : wordList){
            if(curr.equals(endWord)) present = true;
            char[] s = curr.toCharArray();
            
            for(int i = 0; i < n; i++){
                char temp = s[i];
                s[i] = '*';
                String simplified = new String(s);

                if(map.containsKey(simplified)) map.get(simplified).add(curr);
                else{
                    List<String> list = new LinkedList<>();
                    list.add(curr);
                    map.put(simplified, list);
                }

                s[i] = temp;
            }
        }
        if(!present) return 0;

        while(!que.isEmpty()){
            String curr = que.remove();
            int result = time.remove();
            visited.add(curr);
            
            if(curr.equals(endWord)) return result;

            char[] s = curr.toCharArray();

            for(int i = 0; i < n; i++){
                char temp = s[i];
                s[i] = '*';
                String simplified = new String(s);
                
                if(map.containsKey(simplified)) for(String next : map.get(simplified)) if(!visited.contains(next)){
                    que.add(next);
                    time.add(result + 1);
                }

                s[i] = temp;
            }
        }

        return 0;
    }
}

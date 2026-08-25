class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> post = new HashMap<>();
        Map<Integer, Stack<Integer>> pre = new HashMap<>();
        Queue<Integer> que = new ArrayDeque<>();

        for(int[] pair : prerequisites){
            if(pair[0] == pair[1]) return false;

            if(!post.containsKey(pair[0])) post.put(pair[0], new HashSet<>());
            post.get(pair[0]).add(pair[1]);
        }

        for(int[] pair : prerequisites){
            if(!pre.containsKey(pair[1])) pre.put(pair[1], new Stack<>());
            pre.get(pair[1]).push(pair[0]);
        }

        for(int i = numCourses - 1; i >= 0; i--) if(!post.containsKey(i)){
            if(pre.containsKey(i)) que.add(i);
            else numCourses--;
            //while(!pre.get(i).isEmpty()) que.add(pre.get(i).pop());
        }

        while(!que.isEmpty()) {
            numCourses--;
            int curr = que.remove();
            if(!pre.containsKey(curr)) continue;
            Stack<Integer> stack = pre.get(curr);

            while(!stack.isEmpty()){
                int course = stack.pop();
                Set<Integer> set = post.get(course);

                set.remove(curr);
                if(set.isEmpty()) que.add(course);
            }
        }

        if(numCourses == 0) return true;
        else return false;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(char c : tasks){
            if(!map.containsKey(c)){
                map.put(c, list.size());
                list.add(-1);
            }
            else list.set(map.get(c), list.get(map.get(c)) - 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(list);
        Queue<int[]> queue = new ArrayDeque<>();
        int time = 0;

        while(!heap.isEmpty() || !queue.isEmpty()){
            if(!queue.isEmpty() && queue.peek()[0] == time) heap.add(queue.remove()[1]);

            if(!heap.isEmpty()){
                if(heap.peek() != -1){
                    queue.add(new int[]{time + n + 1, heap.remove() + 1}); //0 is time, 1 is task count
                }
                else heap.remove();
            }

            time++;
        }

        return time;
    }
}

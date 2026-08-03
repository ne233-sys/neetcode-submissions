class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];

        int a = 0, b = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++) p.add(stones[i]);

        while(p.size() > 1){
            a = p.poll();
            b = p.poll();
            if(a != b) p.add(Math.abs(a - b));
        }

        if(p.size() == 0) return 0;
        return p.poll();
    }
}

public class Node {
    Queue<Node> next;
    int val;
    boolean visited;

    Node(int num){
        this.next = new ArrayDeque<>();
        this.visited = false;
        this.val = num;
    }
}

class Solution {
    private int count;
    public boolean validTree(int n, int[][] edges) {
        if(n == 1) return true;

        count = 0;

        Map<Integer, Node> map = new HashMap<>();

        for(int[] pair : edges){
            if(!map.containsKey(pair[0])) map.put(pair[0], new Node(pair[0]));
            if(!map.containsKey(pair[1])) map.put(pair[1], new Node(pair[1]));

            Node temp1 = map.get(pair[0]);
            Node temp2 = map.get(pair[1]);

            temp1.next.add(temp2);
            temp2.next.add(temp1);
        }

        return dfs(map.get(edges[0][0]), -1) && count == n;
    }

    private boolean dfs(Node curr, int prev){
        count++;
        curr.visited = true;

        while(!curr.next.isEmpty()){
            Node next = curr.next.remove();
            if(next.visited && next.val != prev) return false;
            if(!next.visited && !dfs(next, curr.val)) return false;        
        }
        return true;
    }
}

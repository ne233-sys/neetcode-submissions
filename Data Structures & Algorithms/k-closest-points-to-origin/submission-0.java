class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<Pair<Double, int[]>> p = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        for(int i = 0; i < points.length; i++){
            double temp = Math.sqrt(Math.pow(0 - points[i][0], 2) + Math.pow(0 - points[i][1], 2));
            Pair<Double, int[]> pair = new Pair<>(temp, points[i]);
            p.add(pair);
        }
        for(int i = 0; i < k; i++) result[i] = p.poll().getValue();
        return result; 
    }
}

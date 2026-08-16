class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int stored = 0, start = 0, stops = 0, i = 0, dif;
        boolean loop = false;

        while(stops < gas.length){
            if(i == gas.length){
                i = 0;
                loop = true;
            }
            if(start == gas.length) start = 0;

            dif = gas[i] - cost[i];

            if(stored + dif < 0) {
                if(loop) return -1;
                start = i + 1;
                stored = 0;
                stops = 0;
            }
            else{
                stored += dif;
                stops++;
            }

            i++;
        }

        return start;
    }
}

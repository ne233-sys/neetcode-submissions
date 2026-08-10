class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int l = temperatures.length;
        int[] result = new int[l];

        if(l < 2) return result;

        Stack<Integer> temp = new Stack<>();
        Stack<Integer> pos = new Stack<>();

        temp.push(temperatures[l - 1]);
        pos.push(l - 1);

        for(int i = l - 2; i >= 0; i--){
            int curr = temperatures[i];
            if(curr < temp.peek()){
                result[i] = pos.peek() - i;
                temp.push(curr);
                pos.push(i);
            }
            else {
                while(!temp.isEmpty() && temp.peek() <= curr){
                    temp.pop();
                    pos.pop();
                }
                
                if(!temp.isEmpty()) result[i] = pos.peek() - i;

                temp.push(curr);
                pos.push(i);
            }
        }

        return result;
    }
}

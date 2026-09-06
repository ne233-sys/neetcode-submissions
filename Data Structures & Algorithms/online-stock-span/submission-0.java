class StockSpanner {
    private Deque<int[]> stack;
    private int timer;

    public StockSpanner() {
        this.stack = new ArrayDeque<>();
        this.timer = 0;
        stack.push(new int[]{Integer.MAX_VALUE, 0});
    }
    
    public int next(int price) {
        timer++;

        if(stack.isEmpty() || stack.peek()[0] > price){
            stack.push(new int[]{price, timer});
            return 1;
        }
        else{
            while(stack.peek()[0] <= price) stack.pop();
            int result = timer - stack.peek()[1];
            stack.push(new int[]{price, timer});
            return result;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
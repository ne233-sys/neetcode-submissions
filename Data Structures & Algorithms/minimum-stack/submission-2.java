class MinStack {

    private LinkedList<Integer> list;
    private LinkedList<Integer> min;

    public MinStack() {
        this.list = new LinkedList<>();
        this.min = new LinkedList<>();
    }
    
    public void push(int val) {
        list.addFirst(val);
        if(min.isEmpty() || val < min.peek()) min.addFirst(val);
        else min.addFirst(min.peek());
    }
    
    public void pop() {
        list.pop();
        min.pop();
    }
    
    public int top() {
        return list.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

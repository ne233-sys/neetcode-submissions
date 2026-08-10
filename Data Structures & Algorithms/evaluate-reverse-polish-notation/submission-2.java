class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(String c : tokens) stack.push(c);

        return rec(stack);
    }

    private int rec(Stack<String> stack){
        String curr = stack.pop();

        switch(curr){
            case "+":
                return rec(stack) + rec(stack);
            case "-":
                return -(rec(stack)) + rec(stack);
            case "*":
                return rec(stack) * rec(stack);
            case "/":
                int first = rec(stack), second = rec(stack);
                return second / first;
            default:
                return Integer.parseInt(curr); //The default case
        }
    }
}

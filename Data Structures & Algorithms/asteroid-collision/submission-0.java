class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new LinkedList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int num : asteroids){
            if(num > 0) stack.push(num);
            else{
                while(!stack.isEmpty() && stack.peek() < (-1 * num)) stack.pop();

                if(stack.isEmpty()) list.add(num);
                else if(stack.peek() == (-1 * num)) stack.pop();
            }
        }

        while(!stack.isEmpty()) list.add(stack.removeLast());

        int[] result = new int[list.size()];
        int i = 0;
        for(int num : list){
            result[i] = num;
            i++;
        }

        return result;
    }
}
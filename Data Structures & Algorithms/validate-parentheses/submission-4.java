class Solution {
    public boolean isValid(String s) {
        int length = s.length(), open = 0;
        if(length%2 == 1) return false;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < length; i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
                open++;
            }
            else if(s.charAt(i) == '{'){
                stack.push(s.charAt(i));
                open++;
            }
            else if(s.charAt(i) == '['){
                stack.push(s.charAt(i));
                open++;
            }
            else if(s.charAt(i) == ')'){
                if(stack.empty()) return false;
                if(stack.pop() != '(') return false;
                open--;
            }
            else if(s.charAt(i) == '}'){
                if(stack.empty()) return false;
                if(stack.pop() != '{') return false;
                open--;
            }
            else if(s.charAt(i) == ']'){
                if(stack.empty()) return false;
                if(stack.pop() != '[') return false;
                open--;
            }
            else return false;

        }
        if(open != 0) return false;
        else return true;
    }
}

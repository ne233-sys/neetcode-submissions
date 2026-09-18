class Solution {
    enum State {
        WORD, SLASH, CURR, PREV
    }

    public String simplifyPath(String path) {
        if(path.length() < 2) return "/";

        State state = State.SLASH;
        String temp = "", result = "/";
        ArrayDeque<String> stack = new ArrayDeque();

        for(int i = 1; i < path.length(); i++){
            char c = path.charAt(i);

            switch(state){
                case State.SLASH:
                    if(c == '/') break;
                    else if(c == '.') state = State.CURR;
                    else {
                        state = State.WORD;
                        temp = Character.toString(c);
                    }
                    break;
                case State.CURR:
                    if(c == '/') state = State.SLASH;
                    else if(c == '.') state = State.PREV;
                    else {
                        state = State.WORD;
                        temp = "." + Character.toString(c);
                    }
                    break;
                case State.PREV:
                    if(c == '/'){
                        state = State.SLASH;
                        if(!stack.isEmpty()) stack.pop();
                    }
                    else {
                        state = State.WORD;
                        temp = ".." + Character.toString(c);
                    }
                    break;
                case State.WORD:
                    if(c == '/'){
                        state = State.SLASH;
                        stack.push(temp);
                    }
                    else temp += c;
                    break;
                default:
                    break;
            }
        }
        if(state == State.WORD) stack.push(temp);
        else if(state == State.PREV && !stack.isEmpty()) stack.pop();

        if(stack.isEmpty()) return result;
        while(!stack.isEmpty()) result += stack.removeLast() + "/";
        result = result.substring(0, result.length() - 1);

        return result;
    }
}
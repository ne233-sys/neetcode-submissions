class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs[0].length() == 0) return "";
        String result = "";
        
        int min = 200;
        char c;

        for(String s : strs) if(s.length() < min) min = s.length();

        for(int i = 0; i < min; i++){
            c = strs[0].charAt(i);

            for(String s : strs){
                if(s.charAt(i) != c) return result; 
            }

            result += c;
        }

        return result;
    }
}
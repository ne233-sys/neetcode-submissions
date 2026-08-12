class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs[0].length() == 0) return result;

        int min = 200;
        char c;
        boolean end = false;

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
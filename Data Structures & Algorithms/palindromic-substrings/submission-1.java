class Solution {
    public int countSubstrings(String s) {
        int len = s.length(), j, count = s.length();
        
        if(len == 1) return 1;
        if(s.charAt(0) == s.charAt(1)) count++;
        if(len == 2) return count;

        for(int i = 2; i < len; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                j = 1;
                count++;
                while(i - 1 - j >= 0 && i + j < len && s.charAt(i-1-j) == s.charAt(i+j)){
                    j++;
                    count++;
                }
                j--;
            }
            if(s.charAt(i) == s.charAt(i-2)){
                j = 1;
                count++;
                while(i - 2 - j >= 0 && i + j < len && s.charAt(i-2-j) == s.charAt(i+j)){
                    j++;
                    count++;
                }
                j--;
            }
        }

        return count;
    }
}
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length(), j, curr;

        if(len <= 3 && s.charAt(0) == s.charAt(len - 1)) return s;

        String max;
        if(s.charAt(0) == s.charAt(1)) max = s.substring(0, 2);
        else max = s.substring(0, 1);

        for(int i = 2; i < len; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                j = 1;
                curr = 2;
                while(i - 1 - j >= 0 && i + j < len && s.charAt(i-1-j) == s.charAt(i+j)){
                    curr += 2;
                    j++;
                }
                j--;

                if(curr > max.length()) max = s.substring(i - 1 - j, i + j + 1);
            }
            if(s.charAt(i) == s.charAt(i-2)){
                j = 1;
                curr = 3;
                while(i - 2 - j >= 0 && i + j < len && s.charAt(i-2-j) == s.charAt(i+j)){
                    curr += 2;
                    j++;
                }
                j--;

                if(curr > max.length()) max = s.substring(i - 2 - j, i + j + 1);
            }
        }

        return max;
    }
}

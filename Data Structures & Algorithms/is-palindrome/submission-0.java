class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 1) return true;

        s = s.toLowerCase();
        int i = 0;

        for(i = 0; i < s.length() - 1; i++){
            if(!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))){
                s = s.substring(0, i) + s.substring(i + 1, s.length());
                i--;
            }
        }
        if(!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))) s = s.substring(0, i);

        for(i = 0; i < s.length() / 2; i++) if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return true;
    }
}

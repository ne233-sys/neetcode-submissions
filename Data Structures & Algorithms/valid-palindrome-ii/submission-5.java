class Solution {
    public boolean validPalindrome(String s) {
        if(s.length() < 3) return true;

        boolean once = false;
        int l = 0, r = s.length() - 1;

        while(l + 1 < r){
            if(s.charAt(l) != s.charAt(r)){
                if(once) return false;

                if(s.charAt(l+1) == s.charAt(r) && s.charAt(l+2) == s.charAt(r-1)) l++;
                else if (s.charAt(l) == s.charAt(r-1) && s.charAt(l+1) == s.charAt(r-2)) r--;
                else return false;

                once = true;
            }

            l++;
            r--;
        }

        if(r + 1 == l && once && s.charAt(l) != s.charAt(r)) return false;

        return true;
    }
}
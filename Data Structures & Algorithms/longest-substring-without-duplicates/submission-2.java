class Solution {
    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        if(size < 2) return size;
        
        int left = 0, right = 0, max = 0;
        char l, r;
        Set<Character> set = new HashSet<>();
        
        while(right < size){
            r = s.charAt(right);
            if(!set.contains(r)){
                set.add(r);
                right++;
            }
            else{
                if(right - left > max) max = right - left;

                right++;

                while(s.charAt(left) != r){
                    set.remove(s.charAt(left));
                    left++;
                }

                left++;
            }
        }

        if(right - left > max) max = right - left;
        return max;
    }
}

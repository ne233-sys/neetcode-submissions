class Solution {
    public void reverseString(char[] s) {
        int h = s.length / 2, b = s.length - 1;
        for(int i = 0; i < h; i++){
            char temp = s[b - i];
            s[b - i] = s[i];
            s[i] = temp;
        }
    }
}
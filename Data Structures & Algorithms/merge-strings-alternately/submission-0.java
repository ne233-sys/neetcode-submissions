class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] word = new char[word1.length() + word2.length()];

        for(int i = 0; i < Math.min(word1.length(), word2.length()); i++){
            word[i*2] = word1.charAt(i);
            word[i*2 + 1] = word2.charAt(i);
        }

        if(word1.length() < word2.length()) for(int i = 0; i < word2.length() - word1.length(); i++) word[word1.length() * 2 + i] = word2.charAt(i + word1.length());
        else for(int i = 0; i < word1.length() - word2.length(); i++) word[word2.length() * 2 + i] = word1.charAt(i + word2.length());

        return new String(word);
    }
}
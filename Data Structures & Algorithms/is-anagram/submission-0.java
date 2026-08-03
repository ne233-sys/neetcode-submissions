class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hash = new HashMap<>(s.length());

        for(int i = 0; i < s.length(); i++){
            if(hash.containsKey(s.charAt(i))) hash.put(s.charAt(i), hash.get(s.charAt(i)) + 1);
            else hash.put(s.charAt(i), 1);
        }

        for(int i = 0; i < t.length(); i++){
            if(hash.containsKey(t.charAt(i))) hash.put(t.charAt(i), hash.get(t.charAt(i)) - 1);
            else return false;
        }

        for(int i = 0; i < s.length(); i++) if(hash.get(s.charAt(i)) != 0) return false;
        return true;
    }
}

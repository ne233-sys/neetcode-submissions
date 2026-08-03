class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> res = new HashMap<>();

        for(String s : strs){ 
            int[] count = new int[26];

            for(char c : s.toCharArray()) count[c - 'a']++;
            String key = Arrays.toString(count); //creates a String key out of an int array representing the English alphabet

            res.putIfAbsent(key, new ArrayList<>()); //creates a new list for this key, if absent
            res.get(key).add(s); //adds elements to the list
        }

        return new ArrayList<>(res.values());
    }
}

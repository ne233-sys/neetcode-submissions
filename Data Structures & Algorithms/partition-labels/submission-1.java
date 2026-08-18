class Solution {
    public List<Integer> partitionLabels(String s) {
        char c;
        int l = 0, r = 0;

        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) map.put(s.charAt(i), i);

        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);

            if(i > r){
                result.add(r + 1 - l);
                l = r + 1;
                r = map.get(c);
                set.add(c);
            }

            if(!set.contains(c)){
                set.add(c);
                if(map.get(c) > r) r = map.get(c);
            }

            if(r == s.length() - 1){
                result.add(r + 1 - l);
                return result;
            }
        }

        return result;
    }
}

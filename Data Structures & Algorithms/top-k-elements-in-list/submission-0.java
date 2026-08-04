class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //2001 possible numbers from -1000 to 1000
        Map<Integer, Integer> map = new HashMap<>(); //map of every present number

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }


        ArrayList<Integer>[] freq = new ArrayList[nums.length + 1]; //array of ArrayLists, index represents frequency and the list stores numbers belonging to it 
        for(int i = 0; i < freq.length; i++) freq[i] = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int count = 0;
        for(int i = nums.length; count < k && i >= 0; i--) if(!freq[i].isEmpty()) {
            for(int j = 0; count < k && j < freq[i].size(); j++) result[count++] = freq[i].get(j);
        }

        return result;
    }
}

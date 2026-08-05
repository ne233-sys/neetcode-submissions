class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        int start, end, max = 1;

        for(int i = 0; i < nums.length; i++) set.add(nums[i]);

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                start = nums[i];
                while(set.contains(start - 1)) start--;

                end = start;
                while(set.contains(end + 1)){
                    set.remove(end);
                    end++;
                }
                if(end + 1 - start > max) max = end + 1 - start;
            }
        }

        return max;
    }
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 0, num2 = 0, count1 = 0, count2 = 0;
        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            if(count1 < 1 && num != num2) num1 = num;
            else if(count2 < 1 && num != num1) num2 = num;

            if(num1 == num) count1++;
            else if(num2 == num) count2++;
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for(int num : nums) if(num == num1) count1++;
        if(count1 > nums.length / 3) list.add(num1);

        for(int num : nums) if(num == num2) count2++;
        if(count2 > nums.length / 3) list.add(num2);

        return list;
    }
}
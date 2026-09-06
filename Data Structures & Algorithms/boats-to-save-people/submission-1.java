class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int left = 0, right = people.length - 1, count = 0;
        int[] counts = new int[limit];
        int[] temp = new int[people.length];

        for(int num : people) counts[num - 1]++;
        if(limit > 1) for(int i = 1; i < limit; i++) counts[i] += counts[i - 1];
        for(int i = people.length - 1; i >= 0; i--){
            temp[counts[people[i] - 1] - 1] = people[i];
            counts[people[i] - 1]--;
        }

        while(left < right){
            count++;

            if(temp[left] + temp[right] <= limit) left++;
            right--;
        }

        if(left == right) count++;
        return count;
    }
}
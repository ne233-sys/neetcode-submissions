class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int left = 0, right = people.length - 1, count = 0;
        Arrays.sort(people);

        while(left < right){
            count++;

            if(people[left] + people[right] <= limit) left++;
            right--;
        }

        if(left == right) count++;
        return count;
    }
}
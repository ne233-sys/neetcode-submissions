class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] == target) return 0;
        
        int left = 0, right = nums.length - 1, k = 0, middle = 0;

        if(nums[left] > nums[right]){
            while(left + 1 < right){
                middle = left + (right - left) / 2;

                if(nums[middle] == target) return middle;

                if(nums[middle] > nums[right]) left = middle;
                else if(nums[middle] < nums[left]) right = middle;
            }

            if(nums[middle] < nums[middle + 1]) k = middle;
            else k = middle + 1;
        }

        left = k;
        right = nums.length - 1 + k;

        while(left <= right){
            middle = (left + (right - left) / 2);
            int mid = middle % nums.length;

            if(target < nums[mid]) right = middle - 1;
            else if(target > nums[mid]) left = middle + 1;
            else return mid;
        }

        return -1;
    }
}
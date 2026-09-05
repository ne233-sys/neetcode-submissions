class Solution {
    public void sortColors(int[] nums) {
        int leftOffset = 0, rightOffset = nums.length - 1;

        for(int i = 0; i <= rightOffset; i++){
            if(nums[i] == 2){
                if(nums[rightOffset] != 2){
                    int temp = nums[i];
                    nums[i] = nums[rightOffset];
                    nums[rightOffset] = temp;
                    rightOffset--;
                }
                else if(rightOffset != i){ 
                    while(nums[rightOffset] == 2 && i < rightOffset) rightOffset--;
                    
                    int temp = nums[i];
                    nums[i] = nums[rightOffset];
                    nums[rightOffset] = temp;
                    rightOffset--;
                }
            }

            if(nums[i] == 0){
                if(nums[leftOffset] != 0){
                    int temp = nums[i];
                    nums[i] = nums[leftOffset];
                    nums[leftOffset] = temp;
                    leftOffset++;
                }
                else if(leftOffset != i){ 
                    while(nums[leftOffset] == 0 && i > leftOffset) leftOffset++;

                    int temp = nums[i];
                    nums[i] = nums[leftOffset];
                    nums[leftOffset] = temp;
                    leftOffset++;
                }
            }
        }

    }
}
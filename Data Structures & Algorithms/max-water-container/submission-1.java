class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1, max = (right - left) * Math.min(heights[left], heights[right]), curr;

        while(right != left){
            if(heights[left] > heights[right]) right--;
            else left++;

            curr = (right - left) * Math.min(heights[left], heights[right]);
            if (curr > max) max = curr;
        }

        return max;
    }
}

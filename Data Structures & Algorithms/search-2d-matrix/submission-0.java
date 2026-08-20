class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length * matrix[0].length, left = 0, right = length - 1;

        while (left <= right) {
            int middle = left + ((right - left) / 2), curr = matrix[middle / matrix[0].length][middle % matrix[0].length];
            if (curr > target) {
                right = middle - 1;
            } else if (curr < target) {
                left = middle + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}

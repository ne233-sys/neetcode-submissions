class Solution {
    private int[] arr;

    public int minEatingSpeed(int[] piles, int h) {
        arr = piles;
        int left = 1, right = 1, result;

        for(int i : piles) if(i > right) right = i;
        result = right;

        while(left <= right){
            int middle = left + ((right - left) / 2);

            if(confirm(middle, h)){
                result = middle;
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
        }

        return result;
    }

    private boolean confirm(int rate, int h){
        for(int i : arr){
            if(h < 0) return false;
            else h -= ((i - 1) / rate) + 1;
        }
        if(h < 0) return false;
        else return true;
    }
}

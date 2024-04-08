class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if ((mid == low || nums[mid - 1] < nums[mid]) && (mid == high || nums[mid + 1] < nums[mid])){ //Checks if middle element is the peak by comparing it with it's neighbors
                return mid;
            } else if(nums[mid + 1] > nums[mid]) { //Moves to the right if mid + 1 is greater than mid
                low = mid + 1;
            } else{ //Else moves to left side of the array
                high = mid - 1;
            }
        }
        return 1212;
    }
}
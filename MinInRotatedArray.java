class Solution {
    public int findMin(int[] nums) {
        int low = 0; int high = nums.length - 1;

        while (low <= high){
            if(nums[low] <= nums[high]){ //Checks if the array is sorted
                return nums[low];
            }
            int mid = low + (high - low) / 2; //Calculates the middle element
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == high || nums[mid] < nums[mid + 1])){ //Checks if min is the minimum element
                return nums[mid];
            } else if(nums[low] <= nums[mid]){ //Moves to the right if the right side is unsorted
                low = mid + 1;
            } else{ //Otherwise moves to the left side
                high = mid - 1;
            }
        }
        return 1212;
    }
}
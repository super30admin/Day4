/*
TC - O(logn)
SC - O(1)
*/

class min_find {
    public int findMin(int[] nums) {
         if (nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length - 1; 
                                    
        while (low <= high) {

            int mid = low + (high - low) / 2; 
            if (nums[low] <= nums[high])
                return nums[low]; 
            if ((mid == nums.length || nums[mid] < nums[mid + 1]) &&
                    (mid == 0 || nums[mid] < nums[mid - 1])) { 
                return nums[mid];
            } else if (mid != nums.length && nums[low] <= nums[mid]) { 
                low = mid + 1;
            } else { 
                high = mid - 1;
            }
        }
        return 789;
    }
}
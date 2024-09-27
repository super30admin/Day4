// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



class FindMinRotatedSortedArr {
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
        return -1;
    }
} 
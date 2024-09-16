// Time complexity - same as Binary Search - O(log n)
// Works on leetcode

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        // Start Binary search
        while(low <= high){
            int mid = low + (high - low) / 2;
            // Stopping condition - mid has reached an end
            // if(((mid == 0) && (nums[mid] < nums[mid + 1])) || ((mid == nums.length - 1) && (nums[mid] < nums[mid - 1])))
            if(((mid == 0) || (nums[mid] < nums[mid - 1])) && (((mid == nums.length - 1) || (nums[mid] < nums[mid+1]))))
            {
                return nums[mid];
            }
            else if(nums[high] < nums[mid]){
                // Move to the right half
                low = mid + 1;
            }
            else{
                // Move to the left half
                high = mid - 1;
            }
        }
        // If nothing is found
        return -1;
    }
}

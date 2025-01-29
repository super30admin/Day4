class Solution {

    private int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length; 

        while(low <= high) {
        int mid = low + (high - low) / 2;

        if(nums[mid] >= target) {
                ans = mid;  
                high = mid - 1;  
            }
        else {
                low = mid + 1; 
            }
        }
        return ans;
    }

    private int upperBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        while(low <= high) {
        int mid = low + (high - low) / 2;

        if(nums[mid] > target) {
                ans = mid;  
                high = mid - 1;
        }
        else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
   int firstOcc = lowerBound(nums, target);  

        // Check if the target is present in the array or not
        if(firstOcc == nums.length || nums[firstOcc] != target) return new int[]{-1, -1}; 

        // Function call to find the last occurrence (upper bound)
        int lastOcc = upperBound(nums, target) - 1;  
        
        return new int[]{firstOcc, lastOcc};  
    }
}

// Time Complexity :    2*O(logn)
// Space Complexity :   O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    None

/* Your code here along with comments explaining your approach in three sentences only - 

We use lower bound to find the first occurence of the element and the upper bound - 1 to get the last occurence of the element 

*/

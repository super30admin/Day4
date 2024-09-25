// Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if ((mid == 0 || nums[mid-1] > nums[mid]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            else if (nums[mid] > nums[high]){
                    // right unsorted array
                    low = mid + 1;
                }
            else{
                    // left is unsorted
                    high = mid -1;
                }
                
            
        }
        return -1;
        
    }
}

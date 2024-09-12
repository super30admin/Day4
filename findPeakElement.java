// Time Complexity : O(logn)
// Space Complexity : O(1) constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach 
//My Approach
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            //check whether the mid element is less than previous element, then check only right sub-half
            if(mid-1 >= 0 && nums[mid] < nums[mid-1]){
                high = mid - 1;
            }
            
            //check if mid element is lesser than the next element, then check the left sub-half
            else if(mid < nums.length-1 && nums[mid] < nums[mid+1])
                low = mid + 1;
            else
                return mid;
        }
        return -1;
        
        
    }
}
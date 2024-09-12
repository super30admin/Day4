// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return - 1;
        
        int low = 0, high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[low] < nums[high])
                return nums[low];
            
            //check if min
            if((mid == 0 || nums[mid] < nums[mid - 1]) && 
               (mid == nums.length - 1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            //always move opposite of sorted side
            //left sorted
            else if(nums[low] <= nums[mid])
                low = mid + 1;
            //right side sorted
            else
                high = mid - 1;
        }
        return - 1;
    }
}

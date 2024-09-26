// Time Complexity : O(logN)
// Space Complexity : O(1) no additional space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : n/a

class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        
        int start = 0;
        int end = nums.length - 1;
        
        // edge case: no rotation or back to original
        if (nums[start] <= nums[end]){
            return nums[start];
        }
        
        //some rotation - all other cases
        int mid;
        while (start <= end){
            mid = (start + end) / 2;
            
            // inflection point found
            if (nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            
            else if (nums[mid] < nums[mid -1]){
                return nums[mid];
            }
            
            // update
            
            if (nums[mid] > nums[start]){ // unrotated to the left of mid, search for inflection point to the right
                start = mid + 1;
            }
            else if (nums[mid] < nums[start]){ // search to the left
                end = mid - 1;
            }
        }
        
        return 0; 
    }
}
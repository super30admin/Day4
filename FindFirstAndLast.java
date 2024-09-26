// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    For finding the first occurance we keep shifting left when we find the target.
    For finding the last occurance  we keep shifting right when we find the target.
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findOccurance(nums, target, true), findOccurance(nums, target, false)};
    }
    
    public int findOccurance(int[] nums, int target, boolean first){
        
        int ans = -1;
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if (nums[mid] > target) high = mid-1;
            else if (nums[mid] < target) low = mid+1;
            else if (nums[mid] == target){
                ans = mid;
                if (first)
                    high = mid-1;
                else
                    low = mid+1;
            }
        }
        
        return ans;
    }
}
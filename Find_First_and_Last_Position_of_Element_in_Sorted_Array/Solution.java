// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Here we simply find start of target and end of target if start exists and we return the result
 * 2. For start, if we hit target element, we check if index is 0 or previous element is less than current
 *    which can happen only if current occurence of target is first occurence in array. We use binary search for this
 *    If we hit occurence of target other than first, we go to left to find first occurence.
 *    else we go to left if current element is greater than target or go to right if current element is less than target
 * 3. For last, if we hit target element, we check if index is last in array or next element is greater than target element
 *    which can happen only if current occurence of target is last in array. Again we use binary search for this
 *    If we hit occurence of target other than last, we go to right to find last occurence.
 *    else we go to left if current element is greater than target or go to right if current element is less than target
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)return new int[]{-1, -1};
        int[] ans = new int[]{-1, -1};
        
        int start = searchStart(nums, target);
        if(start == -1)return ans;
        
        ans[0] = start;
        ans[1] = searchEnd(nums, target, start);
        
        return ans;
    }
    
    private int searchStart(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
         //search for 1st index
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid - 1] < target)return mid;
                else high = mid - 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return -1;
    }
    
    private int searchEnd(int[] nums, int target, int low){
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                if(mid == nums.length -1 || nums[mid + 1] > target)return mid;
                else low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return -1;
    }
}
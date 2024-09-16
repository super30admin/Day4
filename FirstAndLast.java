// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
  We perform Binary Search twice- once to find the left index and once to find the right index.
  When finding the left index, we restrict search to left of target and when finding right index, we restrict search to right of target.
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{
            binarySearch(nums, target, true), 
            binarySearch(nums, target, false)
        };
    }
    
    private int binarySearch(int[] nums, int target, boolean isLeft) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (nums[mid] == target){
                index = mid;
                if (isLeft)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
                               
            else if (nums[mid] < target)
                low = mid + 1; 
            else 
                high = mid - 1;

                
                
            
        }
        return index;
    }
}
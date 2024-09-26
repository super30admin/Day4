// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int first = binaryFirst(nums, target);
        int last = binaryLast(nums, target);
        return new int[] {first, last};   
        }
    
        private int binaryFirst(int[] nums, int target) {
            
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low)/2;
                if (nums[mid] == target) {
                    if (mid == low || nums[mid] > nums[mid - 1]) {
                        return mid;
                    }
                    else {
                        high = mid - 1;
                    }
                }
                else if (target > nums[mid]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            return -1;
        }
    
        private int binaryLast(int[] nums, int target) {
            
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low)/2;
                if (nums[mid] == target) {
                    if (mid == high || nums[mid] < nums[mid + 1]) {
                        return mid;
                    }
                    else {
                         low = mid + 1;
                    }
                }
                else if (target > nums[mid]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        
    
}
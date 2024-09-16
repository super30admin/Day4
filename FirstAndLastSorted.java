// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        result[0] = find(nums, target, true);
        result[1] = find(nums, target, false);
        return result;

    }

    public int find(int[] nums, int target, boolean first) {

        int low = 0;
        int high = nums.length - 1;
        int index = -1;

         while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < nums[mid] || (first && target == nums[mid])) { 
                high = mid-1;
            }
            else {
                low = mid+1;
            }
            if(nums[mid] == target) index = mid;
        }
        return index;
    }
}
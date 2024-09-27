// Time Complexity : O(log(n))
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//simple binary search
// Your code here along with comments explaining your approach
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int first(int[] nums, int low, int high, int target)
    {
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if( mid == low ||  nums[mid - 1] < nums[mid]) return mid;
                else high = mid - 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            } else low = mid + 1; 
        }
        return -1; 
    }
    public int second(int[] nums, int low, int high, int target)
    {
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == high || nums[mid + 1] > target) return mid;
                // still go right
                else low = mid + 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            } else low = mid + 1; 
        }
        return -1; 
    }
    public int[] searchRange(int[] nums, int target) {

        int left = first(nums, 0, nums.length - 1, target);

        int right = second(nums, 0, nums.length - 1, target);

        return new int[] {left,right};

    }

}
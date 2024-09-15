// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/


// Your code here along with comments explaining your approach

class Solution {
    
    private int leftBinarySearch(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                //check whether it is first occurence
                if(mid == 0 || nums[mid-1] < nums[mid]) { // if 1st condition is true it will never evaluate 2nd expression
                    return mid;
                } else {
                    right = mid -1;
                }
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    private int rightBinarySearch(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                //check whether it is last occurence
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        // two binary searches
        //empty array
        if(nums == null || nums.length == 0 ) return new int []{-1,-1};
        //element is not present
        if(nums[0] > target || nums[nums.length-1] < target) return new int []{-1,-1};
        //first occurence
        int first = leftBinarySearch(nums, 0, nums.length-1, target);
        if(first==-1) return new int []{-1,-1};
        //last occurence
        int last = rightBinarySearch(nums, first, nums.length-1, target);
        return new int[] {first,last};
    }
}

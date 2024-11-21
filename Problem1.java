// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//Approach: we will do binary search on whole array and then binary search on right hand side(for finding rightmost index of target)
//O(t) = O(logn) + O(logn) = O(logn)
//Edge cases to consider:
//1. if nums == null || nums.length == 0
//2. if firstindex == -1, return -1,-1 //we don't need to BS for right hand side
//3. if nums[0] > target || nums[lastIndex] < target, return -1,-1
//we will create two private functions for finding left index and right index using binary search

class Solution {
    //First binary search for finding leftmost index
    private int binarySearchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            //[1,2,8,8,8,8,8,8]
            // l     m       h 
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                //if target is found on mid and mid is the first index only
                if(mid == 0 || nums[mid-1] != nums[mid]){
                    return mid;
                }
                else {
                    //keep moving left
                    high = mid - 1;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
    //Second binary search for finding rightmost index
    private int binarySearchLast(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            //[1,2,8,8,8,8,8,8]
            // l     m       h 
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                //if mid is actually the last index only
                if(mid == nums.length - 1 || nums[mid+1] != nums[mid]){
                    return mid;
                }
                else {
                    //keep moving right
                    low = mid + 1;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        //edge case
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        //if target doesn't exist only in nums array
        if(nums[0] > target || nums[nums.length - 1] < target) return new int[]{-1,-1};
        int firstIndex = binarySearchFirst(nums, target);
        //we don't need to binary search on right hand side
        if(firstIndex == -1) return new int[]{-1,-1};
        int lastIndex = binarySearchLast(nums, target);
        return new int[]{firstIndex, lastIndex};
    }
}
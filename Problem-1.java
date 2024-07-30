// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had to go over the recording to understand the logic.

class Solution {
    private int binarySearchFirst(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low )/ 2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] != nums[mid - 1]){
                    return mid;
                }
                high = mid - 1;
            }else if (nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low )/ 2;
            if(nums[mid] == target){
                if(mid == high || nums[mid] != nums[mid + 1]){
                    return mid;
                }
                low = mid + 1;
            }else if (nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        if(nums.length == 0 || nums[0] > target || nums[high] < target){
            return new int[]{-1,-1};
        }

        int first = binarySearchFirst(nums, low, high, target);
        int last = binarySearchLast(nums, low, high, target);

        return new int[]{first,last};
    }
}
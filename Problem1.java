//Time Complexity: O(logn)
//Space Complexity: constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// we can make use of binary search to search for the target as the elements are in sorted order in the matix

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        int left = binarySearchLeft(nums,target);
        int right = binarySearchRight(nums,target);
        return new int[]{left,right};
    }
    private int binarySearchLeft(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid - 1] < nums[mid])
                    return mid;
                else
                    hi = mid - 1;
            }
            else if (target < nums[mid])
                hi = mid -1;
            else
                lo = mid + 1;
            }
            return -1;
        }
    private int binarySearchRight(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid] < nums[mid + 1])
                    return mid;
                else
                    lo = mid + 1;
            }
            else if (target < nums[mid])
                hi = mid -1;
            else
                lo = mid + 1;
            }
            return -1;
    }
}

// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Perform binary search twice to get first index and then last index


class Solution {
    public int[] searchRange(int[] nums, int target) {
        // To check if array is empty
        if(nums==null || nums.length==0) 
            return new int[] {-1,-1};
        // Element is out of bound
        if(target < nums[0] || target>nums[nums.length-1]) {
            return new int[] {-1,-1};
        }
        // Perform binary search to find left index and right index seperately
        int left = binarySearchLeft(nums, target, 0, nums.length-1);
        // If element is not for left then the element is not in array
        if(left==-1) 
            return new int[] {-1,-1};
        int right = binarySearchRight(nums, target, left, nums.length-1);
        return new int[] {left, right};
        }
    public int binarySearchLeft(int[] nums, int target, int low, int high) {
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid]==target) {
                if(mid==0 || nums[mid]>nums[mid-1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid]>target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public int binarySearchRight(int[] nums, int target, int low, int high) {
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid]==target) {
                if(mid==nums.length -1 || nums[mid]<nums[mid+1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid]>target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

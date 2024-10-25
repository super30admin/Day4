//34. Find First and Last position of an Element in Sorted Array - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//Time Complexity: O(2log(n)) ~ log(n)
//Space Complexity: O(1)

class Solution {

    //to get first index
    public int binarySearchLeft(int[] nums, int target) {
        int low = 0; int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                } else {
                    high = mid-1;
                }
            } else if(nums[mid] > target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    //to get last index
    public int binarySearchRight(int[] nums, int target) {
        int low = 0; int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length -1 || nums[mid] < nums[mid+1]){
                    return mid;
                } else {
                    low = mid+1;
                }
            } else if(nums[mid] > target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        //base case
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int first = binarySearchLeft(nums, target);
        int last = binarySearchRight(nums, target);
        return new int[]{first, last};
    }
}
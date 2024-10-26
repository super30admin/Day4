//Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
//Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
//
//Example 1:
//
//Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
//
//Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]


public class problem1 {
    public int[] searchRange(int[] nums, int target) {
        int[] res={-1,-1};
        int low=0, high=nums.length-1;
        while (low<=high) {
            int mid=(low+high)/2;
            if (nums[mid]==target) {
                res[0]= mid;
                high=mid-1;
            }
            else if (nums[mid]>target) {
                high=mid-1;
            }
            else {low=mid+1;}
        }
        while (low<=high) {
            int mid=(low+high)/2;
            if (nums[mid]==target) {
                res[1]= mid;
                low=mid+1;
            }
            else if (nums[mid]>target) {
                high=mid-1;
            }
            else {low=mid+1;}
        }
        return res;
    }
}

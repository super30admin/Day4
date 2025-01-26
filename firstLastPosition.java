//Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

//  Time Complexity : O(logn) - binary search
//  Space Complexity : O(1) - constant
//  Did this code successfully run on Leetcode : yes
//  Any problem you faced while coding this : no

/*
 * Here, we first try to find the 1st position of the target. So, for finding the 1st position, we have taken cases where mid may be the 1st 
 * postion or if its in the left side array of mid or right side array of mid. From here we get the 1st position.
 * Now, we try to find the last postion, knowing the 1st position, we now traverse from that 1st postion to find the last index of the target 
 */

class Solution {
    private int BinarySearchFirst(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 ||nums[mid]!=nums[mid-1]){
                    return mid;
                }
                else{
                    high = mid -1;
                }
            }
            else if(nums[mid]>target){
                high = mid -1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }

    private int BinarySearchLast(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 ||nums[mid]!=nums[mid+1]){
                    return mid;
                }
                else{
                    low = mid+1;
                }
            }
            else if(nums[mid]>target){
                high = mid - 1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return new int[]{-1,-1};
        }
        if(nums[0]>target){
            return new int[]{-1,-1};
        }
        if(nums[nums.length-1]<target){
             return new int[]{-1,-1};
        }
        int first = BinarySearchFirst(nums, 0, nums.length-1, target);
        if(first== -1){
            return new int[]{-1,-1};
        }
        int last = BinarySearchLast(nums, first, nums.length-1, target);
        if(last== -1){
            return new int[]{-1,-1};
        }
        return new int[]{first,last};
    }
}

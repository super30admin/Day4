//Time complexity: O(log n)
//Space complexity: O(1)
//solved on leetcode: yes
//any doubts: no

import  java.util.*;

class Solution {
    private static int binarySearchLast(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]){
                    return mid;
                }
                else{
                    //keep moving right
                    low=mid+1;
                }
            }
            else if(nums[mid] < target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    private static int binarySearchFirst(int[] nums, int target){
        int low=0;
        int high=nums.length;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid == 0 || nums[mid]>nums[mid-1]){
                    return mid;
                }
                else{
                    //we have to search the left part
                    high=mid-1;
                }
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        //check for null
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};

        if(nums[0] > target || nums[nums.length-1] < target)
            return new int[]{-1, -1};


        int first = binarySearchFirst(nums, target);

        if(first == -1)
            return new int[]{-1, -1};

        int last = binarySearchLast(nums, first, nums.length-1, target);

        return new int[]{first, last};

    }
}
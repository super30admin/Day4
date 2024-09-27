/*******
## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Time Complexity :   O (log n) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (34. Find First and Last Position of Element in Sorted Array)
Any problem you faced while coding this :       No
*******/

class MysearchRange {
    public static int searchFirstIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        while( low < high){
            int mid = low + (high - low) / 2;
            // search on right part
            if(nums[mid] < target){
                low = mid + 1; 
            }
            // search on left part
            else{
                high = mid - 1;
            }
        }
        return low;
    }

    public int[] searchRange(int[] nums, int target) {
        // if nums is null or nums array is empty, then return {-1, -1}
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        // if target is less than first element or higher than last element, then return {-1, -1}
        if( nums[0] > target || nums[nums.length - 1] < target){
            return new int[]{-1, -1};
        }

        // find the first index
        int start = MysearchRange.searchFirstIndex(nums, target);

        if (start == nums.length && nums[start] != target){
            System.out.println("No elements found");
            return new int[]{-1, -1};
        }
        // find the target+1 value in array, then subtract 1 from that index
        // it will be the last index of target
        return new int[]{start, MysearchRange.searchFirstIndex(nums, target+1) - 1};
    }

    public static void main(String args[]) 
    { 
        MysearchRange obj = new MysearchRange();
        int target = 6;
        int[] nums = {2,4,6,6,6,8,9};
        int[] result = obj.searchRange(nums, target);
        System.out.println(result[0] +","+ result[1]);
    }
}

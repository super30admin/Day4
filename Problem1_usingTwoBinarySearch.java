//PROBLEM - Find First and Last Position of Element in Sorted Array
/** 3 Pointer Approcach: 
 * Fact utilized : If we can get half items to compute at each progressive iterarion  
 * the problem can be resolved in Log N time.
 * Here we have rotated array, however at any given iteration we will always have 
 * half array sorted - either left or rigth.
 * First find the First occurance of Number by using Binary Search
 * From that position found First Occurance and Last Occurance Using Find First and Find Last.
 */ 
//
//time Complexity :
// LOG(N)

// Space Complexity :
//  LOG(N)

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : Faced some challage while considering the corner cases => 0th and Nth index.

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int index = BinarySearch(nums, target, 0, nums.length - 1); // Find first occurance;
        if (index == -1)
            return new int[] { -1, -1 };

        int start = findFirst(nums, 0, index, target);
        int last = findLast(nums, index, nums.length - 1, target);

        return new int[] { start, last };
    }

    // Lon N
    int findFirst(int[] nums, int start, int end, int target) {

        int st = start; // saving current first Index

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                st = mid; // updating first index if traget and mid are same;
                end = mid - 1; // decrease end towards left of mid where found
            } else
                start = mid + 1; // pull mid closer to last occurance of firstIndex
        }

        return st;
    }

    // Lon N
    int findLast(int[] nums, int start, int end, int target) {

        int en = end;  // saving current last Index

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                en = mid; // updating last index if traget and mid are same;
                start = mid + 1; // shift start towards right/end where mid where found
            } else
                end = mid - 1; //pull mid closer to last ocuurance of EndIndex
        }

        return en;
    }

    // Log N
    int BinarySearch(int[] nums, int target, int start, int end) {
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;
        if (target == nums[mid])
            return mid;

        if (target < nums[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        return BinarySearch(nums, target, start, end);
    }
}
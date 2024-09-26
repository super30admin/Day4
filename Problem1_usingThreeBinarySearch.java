//PROBLEM - Find First and Last Position of Element in Sorted Array
/** 3 Pointer Approcach: 
 * Fact utilized : If we can get half items to compute at each progressive iterarion  
 * the problem can be resolved in Log N time.
 * Here we have rotated array, however at any given iteration we will always have 
 * Find First Occurance and Last Occurance Using Find First and Find Last in logarithim time.
 * 
 */ 
//
//time Complexity :
// LOG(N)

// Space Complexity :
//  LOG(N)

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : Faced some challage while considering the corner cases => 0th and Nth index.

class Solution2 {
    public int[] searchRange(int[] nums, int target) {

        int start = getfirstItem(nums, 0, nums.length - 1, target);
        int last = getLastItem(nums, 0, nums.length - 1, target);

        return new int[] { start, last };
    }

    int getfirstItem(int[] nums, int start, int end, int target) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midval = nums[mid];

            if (midval == target) {
                if (mid == 0 || nums[mid - 1] != midval) // If mid is the first element OR mid is not equal to previous value we got our first index
                    return mid;
                 
                    end = mid - 1; // this condition will run when left is same as target, 

            } else if (target < midval) { // normal Binary Search 
                end = mid - 1; 
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    int getLastItem(int[] nums, int start, int end, int target) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midval = nums[mid];

            if (midval == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != midval) // If mid is the last element OR mid is not equal to next value we got our first index
                    return mid;
                
                    start = mid + 1; // this condition will run  when right is same as target, 

            } else if (target < midval) { // normal Binary Search 
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

}
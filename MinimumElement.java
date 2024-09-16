/**
Time Complexity : O(log n), where n is the number of elements in the array
Space Complexity : O(1)
Solved on LeetCode : Yes
 */

 //Approach: Binary Search
//  1. We need to find the pivot element. (i.e, pivot element is that element where there's deflection)
//  2. Just check if the left and right neighbors of the element are more than it. If so, return it.
//  3.  Also, check if the array is left sorted or right sorted and then search in the side that's not sorted.

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if((mid == 0 || nums[mid-1] > nums[mid]) && (mid == nums.length-1||nums[mid+1] > nums[mid])) {
                return nums[mid];
            }
            else if(nums[mid] < nums[right]) { //right sorted
                right = mid - 1;
            }
            else left = mid + 1; //left sorted
        }
        return -1;
    }
}
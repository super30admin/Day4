/**
Time Complexity : O(log n), where n is the number of elements in the array
Space Complexity : O(1)
Solved on LeetCode : Yes
 */

 //Approach: Binary Search
//  1. A peak element is one whose left and right neighbors are less than the current number.
//  2. A peak element always exists in the growing side of the array, apart from the fact that if the peak is either first or last element.
//  3. If there's no growing side on the right, move left and vice versa

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if((mid == 0 || nums[mid-1] < nums[mid]) && (mid == nums.length-1 || nums[mid] > nums [mid + 1])) {
                return mid;
            }
            else if(mid > 0 && nums[mid] < nums[mid - 1]) // left neighbor is greater than the current element, so move left
                right = mid - 1;
            else //move right
                left = mid + 1;
        }
        return -1;
    }
}
/**
problem: find the peak element in an array
https://leetcode.com/problems/find-peak-element/

Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution {
    public int findPeakElement(int[] nums) {        
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }

            if (mid != 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

/**
NOTES:

Intuition: We just move towards the side of the higher element because we would always find a peak. 
Array: [1,2,3,4,5,6,7,8, 9]
arr[mid] = 5. If we move to the right, we'll get the last element as the peak. We won't find any peak on the left.
Array: [10,2,3,4,5,6,7,8, 9]
In this case, we get a peak in the left also. But since we can return any peak, last element works.
Array: [4,3,2,1, 0]
We move left because that's the direction of the higher element.
Array: [1,2,5,4,3]
arr[mid] is the peak so return

*/
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * In this solution, I have applied the approach that if an element is bigger than the next element, then we know that next element is the minimum
 * If the iterations end, we know that we did not find the minimum and return the minimum element as the first element of the sorted array
 * 
 * While making decision, I have made use of the fact that at any point in a rotated sorted array, either half will be sorted.
 */
class Solution {
    public int findMin(int[] nums) {
        
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (mid+1 > high) {
                // Array is not rotated and we have reached to the end of the array
                // we will return the first element of the array
                break;
            }
            
            if (nums[mid] > nums[mid+1]) {
                // minimum found
                return nums[mid+1];
            } else if (nums[mid] > nums[low]) {
                // left array is sorted and we need to look at the other half to find the sorted point (break point in sorted array)
                low = mid+1;
            } else {
                // left array is sorted and we need to look at this half including the element at mid
                high = mid;
            }
        }
        
        return nums[0];
    }
}


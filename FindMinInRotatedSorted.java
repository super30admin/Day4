/*
Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach
1. If middle element > high, then the array rotated in the right half
2. Else, search space is left half
*/

public class FindMinInRotatedSorted {
    public int findMin(int[] nums) {
        int low = 0, mid = 0;
        int high = nums.length-1;
        
        while (low < high) {
            mid = low + (high - low)/2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return nums[low];
    }
}
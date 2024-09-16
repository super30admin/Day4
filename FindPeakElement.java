/*
Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach
1. If middle element > middle+1 element, then the search space is left half
2. Else, search space is right half
*/

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0, mid = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            mid = low + (high - low)/2;
            
            if (nums[mid] > nums[mid+1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}
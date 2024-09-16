// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
    We compare middle element with the right element. If it is greater, then the min element is in the right part.
    Otherwise, we change the right to mid, so that we search in the left part.
*/

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right])        
                left = mid + 1;
            else
                right = mid;                    
        }
        return nums[left];
        
    }
}
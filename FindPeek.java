// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Did not know which side to go after comparing the mid. Solved during session.

// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        int lower = 0;
        int upper = nums.length-1;
        int mid = 0;

        //run the binary search
        while(lower<=upper){
            mid = lower + (upper - lower) / 2;

            //check the left and right elements are smaller than mid element
            if((mid == 0 || nums[mid] > nums[mid - 1]) &&
                    (mid == nums.length - 1 || nums[mid] > nums[mid + 1]))
                return mid;

            //update lower if right side number is greater
            else if(nums[mid] < nums[mid+1])
                lower = mid + 1;

            //update higher if left side number is greater
            else
                upper = mid - 1;
        }
        return -1;
    }
}
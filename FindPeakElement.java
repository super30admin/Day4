// Time Complexity : O(logn) n is size of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int findPeakElement(int[] nums) {

        //array is not sorted but we still have a rule for peak that will reduce
        //the search space by half
        int n = nums.length;

        int l=0, h=n-1;

        while(l<=h)
        {
            int m = l + (h-l)/2;

            //check if mid is peak, also take care of edge cases where m is last or first index
            if( (m==n-1 || nums[m] > nums[m+1]) && (m==0 || nums[m] > nums[m-1]))
                return m;

            //if mid is not peak, check neighboring elements and move in the direction of greater element

            else if(m!=n-1 && nums[m] < nums[m+1])
                l = m+1;

            else
                h = m-1;
        }
        return -1;
    }
}

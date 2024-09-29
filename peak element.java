// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :no(needs premium will invest in premium soon)
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
implemented the code by sliding window method
 */
class Solution {
    public int findPeakElement(int[] nums) {
       int low = 0;
       int high = nums.length - 1;

       while(low <= high)
       {
            int mid = low + (high - low)/2;
            if( (mid == 0 || nums[mid] > nums[mid - 1])  && (mid == high || nums[mid] > nums[mid + 1]))
            {
                return mid;
            }
            else if(mid > 0 && nums[mid - 1] > nums[mid])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
       }

       return -1;
    }
}
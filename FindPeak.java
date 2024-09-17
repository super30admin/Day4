// Time Complexity :  O(logn)
// Space Complexity : O(1) since it is iterative binary search.
// Did this code successfully run on Leetcode : Yes Its working
// Any problem you faced while coding this : understanding the concept of peak element. I need take a help of leetcode solution for this.
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, h= nums.length-1;
        while(l<h)
        {
            int m = l+(h-l)/2;
            if(nums[m]<nums[m+1])
                l=m+1;
            else{
                h=m;
            }
        }
        return l;
    }

}
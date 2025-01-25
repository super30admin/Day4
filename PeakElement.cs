// Time Complexity : O(lon n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// performed binary search, find mid and check where is the greater element
// then discard the other half
public class Solution {
    public int FindPeakElement(int[] nums) {
        if(nums == null || nums.Length ==0)
        {
            return -1;
        }
        int l = 0;
        int n = nums.Length;
        int h = n - 1;
        while (l <= h)
        {
            int mid = l +(h-l)/2;
            // check if mid is peak element
            if((mid == l || nums[mid] > nums[mid-1]) && (mid==h || nums[mid] > nums[mid+1] ))
            {
                return mid;
            }
            // if right element is greater discard left half
            else if(nums[mid+1] > nums [mid])
            {
                l= mid+1;         
            }
            else // discard right half
            {
                h= mid-1;
            }
        }
        return 434;
    }
}
// Time Complexity : O(lon n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// approach - performed binary search, discard the half which is not sorted.

public class Solution {
    public int FindMin(int[] nums) {
        int n = nums.Length;
        if(nums == null || n ==0)
        {
            return -1;
        }
        int l = 0;
        int h = n-1;
        while (l<=h)
        {
            // if array is sorted, return the first element
            if(nums[l]<=nums[h])
            {
                return nums[l];
            }

            int mid = l + (h-l)/2;
            // check if mid is the smallest element
            if((mid ==l || nums[mid] < nums[mid-1]) && (mid == h || nums[mid] < nums[mid+1]))
            {
                return nums[mid];
            }
            // if left array is sorted, discard left array
            else if(nums[l]<=nums[mid])
            {
                l = mid +1;
            }
            else // discard right array
            {
                h = mid -1;
            }
        }
        return 33;
    }
}
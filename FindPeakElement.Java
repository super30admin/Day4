
// Time Complexity :O(log(n))
// Space Complexity :Constant Space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach in three sentences only
/* 
 * Since needs to iterate in O(log(n)), use binary search approach by splitting array into two halves
 * Check for mids neighbors, which ever neighbor is greater we move in that direction to search for peak element by eliminating the other half
 * There could be peaks in the other half as well but we are asked to return just one index. So , there will definitely be a peak element towards the side greater than the currents mid. Sometime mid could be the peak element.Then we return that mids index as peak index.
 */
class Solution 
{
    public int findPeakElement(int[] nums) 
    {
        if(nums[]==null||nums.length==0)
        {
            return -1;
        }
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if((mid==nums.length-1||nums[mid]>nums[mid+1]) && (mid==0||nums[mid]>nums[mid-1]))
            {
                return mid;
            }
            if(nums[mid+1]>nums[mid])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return 0;
    }
}

// Time Complexity :O(log(n))
// Space Complexity :Constant Space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach in three sentences only
/* 
 * Move left/right to find the first occurrence
 * Move right/left if the middle element is less/great than the target
 * Move left/right if the middle element is greater/less than the target,Write two functions implementing this logic 
 */
class Solution {
    public int findMin(int[] nums) 
    {
           if(nums==null||nums.length==0)
        {
            return -1;
        }
        
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            if(nums[low]<=nums[high])
            {
                return nums[low];
            }
             int mid=low+(high-low)/2;
            if((mid==0 ||nums[mid]<=nums[mid-1]) && (mid==nums.length-1||nums[mid] <= nums[mid+1]))
            {
                return nums[mid];
            }
            if(nums[low]<=nums[mid])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return 456789;
    }
}
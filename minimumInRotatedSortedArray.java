/**

// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

nums = [2,3,4,5,1]

[5,6,7,0,1,2,4]
              
output = 1


3 4 5 1 2
0 1 2 3 4
    s m e


mid = 2, value = 5

**/

class Solution {
    public int findMin(int[] nums) {
        
        int start = 0;
        int end = nums.length - 1;
        
        if (nums[start] < nums[end])
        {
            return nums[start];
        }
        
        if (nums.length == 2)
        {
            return nums[end];
        }
        
        while (start < end)
        {
            int mid = start + (end - start) / 2;
            
            if (mid < nums.length - 1 && nums[mid + 1] < nums[mid])
            {
                return nums[mid+1];
            }
            
            if (mid > 0 && nums[mid-1] > nums[mid])
            {
                return nums[mid];
            }
            
            if (nums[start] < nums[mid])
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        
        return nums[start] > nums[end] ? nums[end] : nums[start];
    }
}
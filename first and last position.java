// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
implemented the code by visualizing the matrix as a 1 d array
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length - 1;

        int first = binarysearchfirst(0, n, nums, target);
        if(first == -1)
        {
            return new int[]{-1, -1};
        }

        int last = binarysearchlast(first, n, nums, target);

        return new int[]{first, last};
    }

    private int binarysearchfirst(int low, int high, int[] nums, int target)
    {
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
        if(nums[mid] == target)
        {
            if(mid == 0 || nums[mid - 1] < nums[mid])
            {
                return mid;
            }
            else
            {
                high = mid - 1;
            }
        }
        else if(nums[mid] > target)
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

    private int binarysearchlast(int low, int high, int[] nums, int target)
    {
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
        if(nums[mid] == target)
        {
            if(mid == high || nums[mid + 1] > nums[mid])
            {
                return mid;
            }
            else
            {
                low = mid + 1;
            }
        }
        else if(nums[mid] > target)
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
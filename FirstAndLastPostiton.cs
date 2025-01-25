// Time Complexity : O(lon n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// approach - performed two binary serach operations, one to get first position 
// and second to get second operation

public class Solution {
    public int findFirstPos(int[] nums, int low, int high, int target)
    {
        while(low<=high)
        {
            int mid = low + (high-low) / 2;
            Console.WriteLine(mid);
            if(nums[mid] == target)
            {
                if(mid ==low || nums[mid] != nums[mid-1])
                {
                    return mid;
                }
                else
                {
                    high = mid -1;
                }
            }
            else if(target < nums[mid])
            {
                high = mid-1;               
            }
            else
            {
                low = mid+1;
            }
        }
        return -1;
    }

    public int findLastPos(int[] nums, int low, int high, int target)
    {
        while(low<=high)
        {
            int mid = low + (high-low) / 2;
            if(nums[mid] == target)
            {
                if(mid == high || nums[mid] != nums[mid+1])
                {
                    return mid;
                }
                else
                {
                    low = mid +1;
                }
            }
            else if(target < nums[mid])
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return -1;
    }

    public int[] SearchRange(int[] nums, int target) {
        if(nums == null || nums.Length == 0)
        {
            return new int[] {-1,-1};
        }
        int first = findFirstPos(nums,0,nums.Length-1,target);
        if(first == -1)
        {
            return new int[]{-1,-1};
        }
        int last = findLastPos(nums,first,nums.Length-1,target);
        return new int[]{first, last};
    }
}
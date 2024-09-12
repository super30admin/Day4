// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class FindFirstAndLastPosition {
    
    public int[] searchRange(int[] nums, int target)
    {
        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};
        if(nums[0] == target && nums[nums.length-1] == target)
            return new int[]{0, nums.length-1};
            
        int left = binarySearchLeft(nums, target);
        if(left == -1)
            return new int[]{-1,-1};
        int right = binarySearchRight(nums, target, left);
        return new int[]{left, right};
    }

    private int binarySearchLeft(int nums[], int target)
    {
        int low = 0 , high = nums.length -1; 

        while(low <= high)
        {
            int mid = low + (high-low)/2;

            if(nums[mid] == target)
            {
                 // check if this is the first occurence of num if not go left till you find first occurence
                if(mid == 0 || nums[mid-1] < nums[mid])
                    return mid;
                else // look for left most
                    high = mid-1;
            } 
            else if(nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;// first occurence not found
    }

    private int binarySearchRight(int nums[], int target)
    {
        int high = nums.length -1; 

        while(low <= high)
        {
            int mid = low + (high-low)/2;

            if(nums[mid] == target)
            {
                  // check if this is the last occurence of num if not go right till you find first occurence
                if(mid == nums.length-1 || nums[mid] < nums[mid+1])
                    return mid;
                else // look for right most
                    low = mid+1;
            } 
            else if(nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
}

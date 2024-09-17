class Solution {
    //Time O(logN)
    //Space O(1)
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        {
            return new int[] {-1,-1};
        }
        int low = binarysearch(nums, target, true);
        int high = binarysearch(nums, target, false);
        return new int[] {low, high};
    }
    public int binarysearch(int[] nums, int target, boolean left)
    {
        int low = 0 , high = nums.length-1;
        while(low <= high)
        {
            if(left)
            {
                int mid = low + (high-low)/2;
                if(nums[0] == target) return 0;
                if(mid > 0 && nums[mid] == target && nums[mid] > nums[mid-1])
                {
                    return mid;
                }
                if(mid > 0 && nums[mid] >= target)
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
            else
            {
                int mid = low + (high-low)/2;
                if(nums[nums.length-1] == target) return nums.length-1;
                if(mid < nums.length-1 && nums[mid] == target && nums[mid] < nums[mid+1])
                {
                    return mid;
                }
                if(mid < nums.length-1 && nums[mid] <= target)
                {
                    low = mid+1;  
                }
                else
                {
                    high = mid-1;
                }
            }
            
        }
        return -1;
    }
}
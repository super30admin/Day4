class Solution {
    private int firstbinary(int[] nums, int target, int start, int end)
    {
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(nums[mid]==target)
            {
                if(mid == 0 || nums[mid] > nums[mid-1])
                {
                    return mid;
                }
                else
                {
                    end = mid-1;
                }
            }
            else if(nums[mid] > target)
            {
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return -1;
    }
    private int lastbinary(int[] nums, int target, int start, int end)
    {
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(nums[mid]==target)
            {
                if(mid == nums.length-1 || nums[mid] < nums[mid+1])
                {
                    return mid;
                }
                else
                {
                    start = mid+1;
                }
            }
            else if(nums[mid] < target)
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length==0)
        {
            return new int[]{-1,-1};
        }
        if(nums[0]>target || nums[nums.length-1]<target)
        {
            return new int[]{-1,-1};
        }
        int firstindex = firstbinary(nums, target, 0, nums.length-1);
        int lastindex = lastbinary(nums, target, 0, nums.length-1);
        return new int[]{firstindex, lastindex};
    }
}
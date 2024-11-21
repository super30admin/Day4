class Problem1
{
    public int findPeakElement(int[] nums) 
    {
        if(nums.length == 0)
            return -1;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.min(nums[0],nums[1]);
        
        int left = 0;
        int right = nums.length -1;
        
        while (left < right)
        {
            int midpoint = left + (right - left) / 2;
            if(nums[midpoint] < nums[midpoint + 1])
                left = midpoint + 1;
            else 
                right = midpoint;
        }
        
        return left;
    }
}
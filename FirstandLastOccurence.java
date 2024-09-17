// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No






class FirstandLastOccurence{
    public int[] searchRange(int[] nums, int target)
    {
        int[] result = new int[2];
        result[0] = firstIndex(nums, target);
        result[1] = lastIndex(nums, target);
        return result;
    }
    
    private int firstIndex(int[] nums, int target)
    {
        int index=-1;
        int mid;
        int l=0;
        int r=nums.length-1;
        while(l<=r)
        {
            mid = l+(r-l)/2;
            if(target<=nums[mid])
                r=mid-1;
            else
                l=mid+1;
            
            if(nums[mid]==target)
            index=mid;
        }
        return index;
        
    }
    
     private int lastIndex(int[] nums, int target)
    {
        int index=-1;
        int mid;
        int l=0;
        int r=nums.length-1;
        while(l<=r)
        {
            mid = l+(r-l)/2;
            if(target>=nums[mid])
                l=mid+1;
            else
                r=mid-1;
            
            if(nums[mid]==target)
            index=mid;
        }
        return index;
        
    }
    
    
    
    
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums==null || nums.length==0 || target<nums[0] || target>nums[nums.length-1])
            return new int[]{-1,-1};
        int l=leftInd(nums,target);
        if(l==-1)
            return new int[]{-1,-1};
        int r=rightInd(nums,target);
        return new int[]{l,r};
    }
    
    public int leftInd(int[] nums, int target)
    {
        int l=0;
        int h=nums.length-1;
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(nums[m]==target)
            {
                if(m==0 || nums[m-1]!=target)
                    return m;
                h=m-1;
            }
            else if(nums[m]<target)
                l=m+1;
            else
                h=m-1;
        }
        
        return -1;
    }
    
    public int rightInd(int[] nums, int target)
    {
        int l=0;
        int h=nums.length-1;
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(nums[m]==target)
            {

                if(m==nums.length-1 || nums[m+1]!=target)
                    return m;
                l=m+1;
            }
            else if(nums[m]<target)
                l=m+1;
            else
                h=m-1;
        }
        
        return -1;
    }
}

// Time Complexity : O(log n)   
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

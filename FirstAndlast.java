class Solution {
    public int first(int nums[],int low,int high,int target)
    {
        //low=0;
        //high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                if((mid==low) || (nums[mid]>nums[mid-1]))
                {
                    return mid;
                }else{
                    high=mid;
                }
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
      public int last(int nums[],int low,int high,int target)
    {
       // low=0;
        //high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                if((mid==high) || (nums[mid]<nums[mid+1]))
                {
                    return mid;
                }else{
                    low=mid+1;
                }
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int first=first(nums,0,nums.length-1,target);
        int last=last(nums,0,nums.length-1,target);
        return new int[]{first,last};
    }
}
class Solution {
    public int left(int[] nums,int target,int low, int high)
    {
       
        while(high>=low)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
            if(mid==0 || nums[mid-1]<nums[mid])
                return mid;
            else   high=mid-1; 
                }
            else if(nums[mid]>target)   high=mid-1;
            else    low=mid+1;
        }
        return -1;
    }
    public int right(int[] nums,int target,int low, int high)
    {
       
        while(high>=low)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
            if(mid==high || target<nums[mid+1])
                return mid;
            else   low=mid+1; 
                }
            else if(nums[mid]>target)   high=mid-1;
            else    low=mid+1;
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int left=left(nums,target,0,nums.length-1);
        int right=right(nums,target,0,nums.length-1);
        return new int[]{left,right};
    }
}
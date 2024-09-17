class Solution {
    public int findPeakElement(int[] nums) {
        int start=0,end=nums.length;
        return findPeak(nums,start,end);
    }
    public int findPeak(int[] nums,int start ,int end)
    {int mid =(start+end)/2;
            
            if(nums[mid-1]<nums[mid]&&nums[mid]<nums[mid+1])
            {
                findPeak(nums,mid+1,end);
            }else if(nums[mid-1]>nums[mid]&&nums[mid]>nums[mid+1])
            {
                 findPeak(nums,start,mid-1);
            }else{
                return mid;
            }
     return -1;
    }
}
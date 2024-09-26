class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(high>low)
        {
            int mid=low+(high-low)/2;//to prevent overflow
            if (nums[low]<nums[high])  return nums[low];
            if((mid==0 || nums[mid-1]>nums[mid]) && nums[mid+1]>nums[mid])    return nums[mid];
            else if (nums[mid]<nums[high])  high=mid-1;
            else     low=mid+1;
        }
      return nums[low];
    }
}
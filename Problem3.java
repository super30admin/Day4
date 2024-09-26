//Step1. finding the mid
//Step2. comapring the mid and mid+1 and mid and mid-1 if true we found the peak
//Step3. else low=mid+1 
//Complexity O(logn)
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        int n=nums.length;
        if(nums[0]>nums[1])
               return 0;
        if(nums[n-1]>nums[n-2])
            return n-1;
        
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(mid==0 || nums[mid]>nums[mid-1] )
            {
                if(nums[mid]>nums[mid+1])
                {
                    return mid;
                }
                else
                {
                    low=mid+1;
                }
            }
            else
                high=mid-1;
        }
        return -1;
            
    }
}
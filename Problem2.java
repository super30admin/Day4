///Step1. finding the mid
//Step2. comapring the mid and mid+1 or mid and mid-1 if true we found the lowest
//Step3. else low=mid+1 
//Complexity O(logn)
class Solution {
    public int findMin(int[] nums) {
        int low=0, high=nums.length-1;
        if(nums[low]<=nums[high])
            return nums[low];
        while(low<=high)
        {
              int mid=low+(high-low)/2;
                if(nums[mid]>nums[mid+1])
                    return nums[mid+1];
                if(nums[mid-1]>nums[mid])
                    return nums[mid];
                if(nums[mid]>nums[low])
                    low=mid+1;
            else 
                high=mid-1;
            }
        return -1;
        
    }
}
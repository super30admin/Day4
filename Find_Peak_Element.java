class Solution {
    public int findPeakElement(int[] nums) {
        int high=nums.length-1;
        int low=0;
        int mid=0;
        if (nums.length==1)
           return 0;
        if(nums[high]>nums[high-1])
         return high;
         else if(nums[low+1]<nums[low])
          return low;
          
           else{
             while(low<=high){
                mid=(high+low)/2;
                if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])
                  return mid;
                
                if( nums[mid-1]>nums[mid])
                  high=mid;
                
                 else if(nums[mid+1]>nums[mid])
                   low=mid;
             }


          }
          return -1;
    }
}
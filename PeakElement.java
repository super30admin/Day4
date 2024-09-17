// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No




class PeakElement{
    public int findPeakElement(int[] nums) {
        int start=0;
        int end = nums.length-1;
        int mid;
        if(start==end)
            return 0;
        if(nums.length==2)
        {
            if(nums[0]>nums[1])
                return 0;
            else
                return 1;
        }
        
        while(start<=end)
        {
          mid=start+(end-start)/2;
          if(mid==0||mid==nums.length-1||(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]))
              return mid;
          else if(nums[mid]<nums[mid+1])
              start=mid+1;
          else if(nums[mid]<nums[mid-1])
              end=mid;
          }
        
    return 0;  
    }
}
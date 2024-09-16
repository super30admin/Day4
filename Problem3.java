// Time Complexity : O (log n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem3 {
    public int findPeakElement(int[] nums) {
        
      if(nums==null || nums.length==0) return -1;
      int low=0,high=nums.length-1;
    
      while(low<=high)
      {
       int mid=low+(high-low)/2;
       if((mid==0 ||nums[mid]>nums[mid-1]) && (mid==nums.length-1||nums[mid]>nums[mid+1]))
           return mid;
          
        // Peak will be towards larger element. Go towards it
           else if(mid>0 && nums[mid-1]>nums[mid])
        {
              high=mid-1;
        }
      
        else if( mid<nums.length-1 && nums[mid+1]>nums[mid])
        {
            low=mid+1;
          
        }
       
      }
       return 1; 
    
        
    }
}
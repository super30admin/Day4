
// Time Complexity : 2 log n which is equal to  O(logn) where n is number of elements in array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0 , high = nums.length-1, first=-1, last=-1;
        while(low<=high)   // First binary search to find start point
         {    
            int mid= low + (high-low)/2;
            if(nums[mid]==target)
             { 
               if(mid==0)
                {first = mid;break;}
              else if(nums[mid-1]==nums[mid])
                   high=mid-1;
               else 
                {first=mid; break; }
                
             }
            else if(nums[mid]>target)
                  high=mid-1;
            else 
                low =mid+1;
            
         }
        
        if(first==-1) 
          { 
            return new int[]{first,last};
          } 
        low =first; high=nums.length-1;
        
          while(low<=high)   // Second Binary Search to find end point
          {    
            int mid= low + (high-low)/2;
            if(nums[mid]==target)
              { 
               if(mid==nums.length-1)
                {last = mid;break;}
              else if(nums[mid+1]==nums[mid])
                   low=mid+1;
               else 
                {last=mid; break; }
                
               }
            else if(nums[mid]>target)
                  high=mid-1;
            else 
                low =mid+1;
            
           }
        
        return new int[]{first,last};
        
    }
}
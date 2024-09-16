// Time Complexity : O (log n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
        public int findMin(int[] nums) {
        
        if (nums.length == 1) {
          return nums[0];
        }
            
        int low=0,high=nums.length-1;
        if(nums[low]<=nums[high])
            return nums[low];
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            // Minimum always in the unsorted array
            if(nums[low]<=nums[high])
                return nums[low];
            if((mid==nums.length-1 ||nums[mid]<nums[mid+1]) && (mid==0 || nums[mid-1]>nums[mid]))
             {
                 return nums[mid];  
             }
            else if(nums[low]<=nums[mid])
                low=mid+1;
            else high=mid-1;
        }
            return 3000;
    }}

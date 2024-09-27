// Time Complexity :O(Logn) N is the array size
// Space Complexity : O(1) since constant elements in the array;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low= 0;
        int high = nums.length-1;
        int first = binarySearchFirst(nums,target,low,high);
        int second = binarySearchSecond(nums,target,low,high);
        return new int[] {first,second};
    }
    
    private int binarySearchFirst(int[] nums,int target, int low, int high)
    {
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid] == target)
            {
                if(mid==low || nums[mid-1]<nums[mid])
                {return mid;}
                else
                {
                    high = mid-1;
                }
            }
            
            else if(nums[mid]>target)
            {
                high = mid-1;
                
            }
            else
            {
                low = mid+1;
            }
        }
        return -1;
        
        
    }
    
        private int binarySearchSecond(int[] nums,int target, int low, int high)
    {
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid] == target)
            {
                if(mid==high|| nums[mid+1]>nums[mid])
                {return mid;}
                else
                {
                    low = mid+1;
                }
            }
            
            else if(nums[mid]>target)
            {
                high = mid-1;
                
            }
            else
            {
                low = mid+1;
            }
        }
            
            return -1;
      
        
    }
}
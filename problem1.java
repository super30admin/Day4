
/*
Problem is to find the first and last position of the given target element

// Time Complexity : O(log n), as we use binary search to sovle this problem
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
*/
class Problem1 {
    
    public int[] searchRange(int[] nums, int target) 
    {
        int[]res = new int[2];
        
        int leftIndex = findLeft(nums,target);
        int rightIndex = findRight(nums,target);
        res[0]=leftIndex;
        res[1] = rightIndex;
        return res;
    }
    
    public int findLeft(int[]nums,int target)
    {
        int index =-1;
        
        int low = 0;
        int high =nums.length-1;
        
        while(low <= high)
        {
            int mid = (low+high)/2;
            if(nums[mid] >= target)
            {
                high = mid-1;
            }else{
                low = mid+1;
            }
            if(nums[mid] == target)
            {
                index = mid;
            }
        }
        
        return index;
    }
    public int findRight(int[]nums,int target)
    {
        int index =-1;
        
        int low = 0;
        int high =nums.length-1;
        
        while(low <= high)
        {
            int mid = (low+high)/2;
            if(nums[mid] <= target)
            {
                low = mid+1;
            }else{
                high = mid-1;
            }
            if(nums[mid] == target)
            {
                index = mid;
            }
        }
        
        return index;
    }
}
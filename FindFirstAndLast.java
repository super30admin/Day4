// Time Complexity : O(log n) where n is size of array
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        
        int low=0;
        int high = nums.length-1;
        
        int left = binSearch(nums, target, low, high,-1);
        int right = binSearch(nums, target, low, high,1);
        return new int[]{left,right};
        
    }
    
    private int binSearch(int[] nums, int target, int low, int high, int dir){
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid]==target)
            {
             if(dir==-1)   //Find first
                if(low==mid || nums[mid-1]<nums[mid]) return mid; else high = mid-1;
             if(dir==1)    //Find last
                if(high==mid || nums[mid]<nums[mid+1]) return mid; else low = mid+1;
            }
            else
            if(nums[mid]>target) high=mid-1;
            else low = mid+1;
        }
        
        return -1;
    }

}
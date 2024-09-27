// Time Complexity : O(log n) where n is size of array
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FindMin {
    public int findMin(int[] nums) {
        
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        
        int low = 0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(high-low==1 || high-low ==0) return Math.min(nums[high],nums[low]);
            if(nums[mid-1]>nums[mid]) return nums[mid];                         //Value going high to low around mid
            if(nums[mid]>nums[mid+1]) return nums[mid+1];                       //Value going high to low around mid
            if(nums[low]<=nums[mid] && nums[mid]<=nums[high]) return nums[low]; //Fully sorted
            if(nums[low]<=nums[mid]) //Left array sorted - Min on right
                low = mid+1;
            else
                high = mid-1;
        }
        
        
        return -1;
    }
}
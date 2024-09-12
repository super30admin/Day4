/*
Time Complexity: O(log n)
Space Complexity: O(1)


*/




class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        
        if(nums.length == 0 || nums==null)
            return -1;
        
        if(nums.length == 1)
            return nums[0];
        
        if(nums[0]<=nums[nums.length - 1])
            return nums[0];
        
        while(low <=high)
        {
            int mid = low + (high - low)/2;
            if(mid>0 && nums[mid-1]>nums[mid])
                return nums[mid];
            if (nums[low] <= nums[mid]
                    && nums[mid] >= nums[high]) 
            {
                low = mid + 1;
            } 
            
            else {
                high = mid - 1;
            }
        }
        
        return -1;
        
    }
}
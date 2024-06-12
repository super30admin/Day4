class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return -1;
        }
        
        if(nums.length == 1)
        {
            return nums[0];
        }
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high)
        {
            if(nums[low] < nums[high])
            {
                return nums[low];
            }
            
            int mid = low + (high - low) / 2;
            int prev = (mid + nums.length - 1) % nums.length;
            int next = (mid + 1) % nums.length;
            
            if(nums[mid] < nums[prev] && nums[mid] < nums[next])
            {
                return nums[mid];
            }
            
            else if(nums[low] <= nums[mid])
            {
                low = mid + 1;
            }
            
            else
            {
                high = mid - 1;
            }    
        }
        
        return -1;
    }
}

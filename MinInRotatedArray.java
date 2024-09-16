class Solution {
    public int findMin(int[] nums) {
        
        if(nums==null || nums.length==0)
        {
            return -1;
        }
        
        if(nums[0] <= nums[nums.length-1])
        {
            return nums[0];
        }
        
        int low =0;
        int high = nums.length -1;
        
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            
            if(nums[low] <= nums[nums.length-1])
        {
            return nums[low];
        }
            if((mid==0 || nums[mid] < nums[mid-1]) && (mid== nums.length -1 || nums[mid] < nums[mid+1]))
            {
                return nums[mid];
            }
            
            if(nums[mid] >= nums[low])
            {
                low= mid +1;
            }
            else
            {
                high = mid+1;
            }
        }
        return -1;
        
    }
}
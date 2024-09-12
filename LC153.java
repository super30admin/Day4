class Solution {
    public int findMin(int[] nums) {
        
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            
            if(nums[low]<=nums[high])
            {
                return nums[low];
            }
            
            if((mid==nums.length-1 || nums[mid+1]>nums[mid]) && (mid==0 || nums[mid-1]>nums[mid]))
            {
                return nums[mid];
            }
            else if(nums[low]<=nums[mid])
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        
        return 1111111111;
    }
}
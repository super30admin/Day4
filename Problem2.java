class Solution {
    public int findMin(int[] nums) {
        
        int l=0;
        int h=nums.length;
        
        while(l<h)
        {
            int mid = l+(h-l)/2;
            
                if(nums[mid] >nums[mid+1])
                {
                    return nums[mid+1];
                    
                }
            else if(nums[mid] < nums[mid+1])
            {
                h=mid-1;
            }            
            else
            {
                l=mid+1;
            }
            
        }
        
        return nums[0];
        
        
    }
}
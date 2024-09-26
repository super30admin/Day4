class Solution {
    public int findMin(int[] nums) {
        
        if(nums == null || nums.length==0)
            return -1;
        
        int low = 0;
        int high = nums.length-1;
        int min = nums[0];
        while(low <= high){
              int mid = low +(high-low)/2;
            
            if(nums[low] <= nums[high])
                return nums[low];
            
            if(nums[low] <= nums[mid])
                low = mid+1;
            else
                high = mid;
            
            
        }
        
        return -1;
    }
    
  
}

//Time Complexity : O(log(n))
//Space Complexity : O(1)
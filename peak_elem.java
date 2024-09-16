class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null||nums.length==0)
        {
            return -1;
        }
        
        int low = 0;
        int high = nums.length-1;
        int mid =0;
        
        while(low<=high)
        {
            mid = low+(high-low)/2;
            if((mid==0||nums[mid]>nums[mid-1]) &&(mid==nums.length-1 ||nums[mid]>nums[mid+1]))
               {
                   return mid;
               }
             else if(mid!=0 && nums[mid-1]>nums[mid])
               {
                   high = mid-1;
               }
             else if(mid!=nums.length-1 && nums[mid+1]>nums[mid])
               {
                   low = mid+1;
               }
        }
               return -1;
               
        
    }
    
}
//runtime: Since we are using binary search it is O(logn) and O(1) for the rest of the lines and fuctions
//space complexity: since we are not using any additional space it is O(1).

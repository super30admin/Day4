class Solution {
    public int findPeakElement(int[] nums) {
        
    
        int low =0;
        int high = nums.length -1;
        
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
              if ((mid == low || nums[mid] > nums [mid - 1]) && ( mid == high || nums[mid] > nums[mid + 1] ))
                return mid;
            
            else if (mid == high || nums[mid] < nums[mid+1]){ 
                
                        low = mid + 1;
                
            }
               
            else                                             
                high = mid -1;
            
        }
        
        return -1;
        
    }
}
//Time complexity O(logn) 
//space complexity O(1)

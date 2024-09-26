    
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        
        // Do binary search : 
        // Check if mid value is less than the left side neighbour :
        // If yes, then we will definitely get a peak towards left region. 
        while (start <= end){
            mid = start + (end - start)/2 ;
            
            if(( mid == 0  || nums[mid - 1] < nums[mid]) && (mid == nums.length -1  || nums[mid] > nums[mid + 1])) {
                return mid;
            }
            
            else if (mid > 0 && nums[mid - 1] > nums[mid]){
                end =  mid - 1;
            }
            
            else {
                start = mid + 1;
            }
            
            
        }
        
        return -1;
  
    }
}
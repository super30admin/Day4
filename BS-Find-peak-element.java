//Time Complexity: O(Logn)
//Space Complexity: O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        
    
        int low =0;
        int high = nums.length -1;
        
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            //Base case--Checking if mid is greater than both the neighbours, returning the answer
            
            if ((mid == low || nums[mid] > nums [mid - 1]) && ( mid == high || nums[mid] > nums[mid + 1] ))
                return mid;
            
            else if (mid == high || nums[mid] < nums[mid+1]){ //Moving to right
                
                        low = mid + 1;
                
            }
               
            else                                              // Moving to left
                high = mid -1;
            
        }
        
        return -1;
        
    }
}
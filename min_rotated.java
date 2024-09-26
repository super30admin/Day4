Time Complexity : O(logn)

class Solution {
    public int findMin(int[] nums) {
        
        
        int high = nums.length -1 ;
        int low = 0;
        
        
        if ( nums.length == 1) { return nums[0];}
        
        if ( nums[low] < nums[high])
        {
            return nums[0];
        }
        
        
        
        while ( low <= high )
        {
            int mid = low + ( high -low) /2;
            
            
             if (nums[mid] > nums [mid+1] )
            {
                return nums[mid+1];
            }
            
             else if (  nums[mid] < nums[mid-1] )
            {
                return nums[mid];
            }
            
            
            else if ( nums[mid] > nums[0])
            {
                low = mid +1;
            }
            
            else 
            {
                high = mid-1;
            }
            
           
            
        }
        
        return -1;
    }
}
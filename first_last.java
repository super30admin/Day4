Time Complexity : O(logn)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
          return new int[] { startRange ( nums , target) , endRange ( nums , target)};
    }
        
        
         private int startRange ( int [] nums , int target) 
         {
            int low = 0;
            int high = nums.length-1;
             
             while ( low <= high)
             {
                 int mid = low + ( high - low )/2;
                 
                 if ( nums[mid] == target )
                 {
                     
                    if ( mid ==0 || nums[mid-1] !=target)
                    {
                        return mid;
                    }
                    
                    high = mid -1;
                     
                 }
                 
                 else if ( nums[mid] < target  )
                 {
                     low = mid +1;
                 }
                 
                 else if ( nums [mid] > target)
                 {
                     high = mid-1 ;
                 }
             }
        
            return -1;
         }
    
    private int endRange (   int [] nums , int target  )
    {
        
        int low = 0;
        int high = nums.length - 1;
        
        while ( low <= high)
        {
            int mid = low + ( high - low )/2;
            
            if ( nums[mid] == target)
            {
                if ( mid == nums.length - 1 || nums[mid+1] != target )
                {
                    return mid;
                }
                
                low = mid + 1;
            }
            
            else if ( nums[mid] < target) 
            {
                
                low = mid +1;
            }
            
            else {
                
                high = mid -1;
            }
        }
        
        return -1;
        
    }
     
}
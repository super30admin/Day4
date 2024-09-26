
Time Complexity : O(logn)

class Solution {
    public int findPeakElement(int[] nums) {
        
        int low = 0;
        int high = nums.length-1;
        
        if ( nums.length ==1 ) { return 0;}
        if ( nums[low] > nums[low+1]  ) { return 0 ;}
        
        if ( nums[high] > nums [high-1]) { return high;}
        
        while ( low <= high)
        {
                   
          int mid = low + ( high - low)/2;  
            System.out.println(mid);   
          if (( mid == 0 || nums[mid] > nums[mid-1])  &&  ( mid == nums.length-1 || nums[mid] > nums[mid+1]) )
          {
              return mid;
          }
            
            else if ( nums[mid] < nums[mid+1]) { low = mid +1; ; }
            
            else { high = mid -1; System.out.println(mid);}
                
        }
        
        return -1;
        
    }
}
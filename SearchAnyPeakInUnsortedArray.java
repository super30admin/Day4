package BinarySearch;

/*------------------------------------------------------------------------------------------------------
    Time complexity : o(log n) 
    space complexity: o(1)
    Did this code run successfully in leetcode : yes
    problems faces : no
    Apply binary search and check if mid is greater than adjacent elements. if not keep moving towards higher valued adjacent element
    
    */
public class SearchAnyPeakInUnsortedArray {
    
    public int findPeakElement(int[] nums) {
        
        if(nums ==  null || nums.length == 0) return -1;
        
        int left = 0;
        int right = nums.length-1;
        int mid ;
        
        while(left<=right)
        {
            mid = left + (right-left)/2;
            
            if((mid==nums.length-1 || nums[mid] >nums[mid+1]) && (mid==0 || nums[mid] > nums[mid-1]) )
            {
                return mid;
            }
            else if( mid !=0 &&nums[mid] < nums[mid-1]) //num !=0 is required only when we are trying to check if the left element is greater than zero ,because mid can go lower than left but never goes more than right.
            {
                right = mid-1;
            }
            else 
            {
                left = mid+1;
            }
            
        }
        
        return -1;
        
    
   }

}

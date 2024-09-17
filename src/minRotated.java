// Operation:              search
// Time Complexity:       O(logn)
// Space Complexity:        O(1)
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement


package src;

public class minRotated
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{4,5,1,2,3} ;
        Min s = new Min() ;
        System.out.println("Min val: "+s.findMin(arr)) ;
    }
}

class Min {
    public int findMin(int[] nums)
    {
        int l = 0 ;
        int r = nums.length - 1 ;
        int mid = 0 ;
        while(l < r)
        {
            mid = l + (r-l)/2 ;                                             // getting mid index
            if(nums[l]>nums[mid])                                           // if left sub-array is unsorted
            {
                if(nums[mid-1]>nums[mid])                                   // checking if num at mid is minimum or not
                    return nums[mid] ;                                      // if yes, return minimum value
                r = mid - 1 ;                                               // else, continue to left sub-array
            }
            else if(nums[mid]>nums[r])                                      // if right sub-array is unsorted
            {
                if(nums[mid]>nums[mid+1])                                   // checking if num at mid is minimum or not
                    return nums[mid+1] ;                                    // if yes, return minimum value
                l = mid + 1 ;                                               // else, continue to right sub-array
            }
            else
                return nums[l] ;                                            // if array is already sorted
        }
        return nums[mid] ;                                                  // returning value at mid index
    }
}
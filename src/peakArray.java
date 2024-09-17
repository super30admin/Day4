// Operation:              search
// Time Complexity:       O(logn)
// Space Complexity:        O(1)
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement


package src;

public class peakArray
{
    public static void main(String[] args)
    {
        int[] arr = new int[] {1} ;
        findPeak fp = new findPeak() ;
        System.out.println("Position: "+fp.findPeakElement(arr)) ;
    }
}

class findPeak
{
    public int findPeakElement(int[] nums)
    {
        int l = 0 ;
        int r = nums.length - 1 ;

        return find(nums, l, r) ;
    }

    private int find(int[] nums, int l, int r)
    {
        int mid = 0;
        while (l <= r)
        {
            mid = l + (r-l)/2 ;                                             // getting mid index
            if(mid == 0 || mid == nums.length-1)                            // if index of element is first or last
                if(nums[mid]>nums[r])                                       // if element at mid is peek
                    return mid ;
                else                                                        // if element at index r is peek
                    return r ;
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])              // if element at mid is peek
                return mid ;
            else
            {
                if(nums[mid+1]>nums[mid])                                   // if element on right is greater than element at mid
                    l = mid+1 ;
                else                                                        // if element on left is greater than element at mid
                    r = mid-1 ;
            }
        }
        return mid ;
    }
}
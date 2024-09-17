// Operation:               search
// Time Complexity:       O(logm*logn)
// Space Complexity:         O(1)
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement after understanding the logic in class


package src;

public class firstLastPosInSorted
{
    public static void main(String[] args) {
        int[] arr = new int[] {5,7,7,8,8,10,11} ;
        int target = 8 ;
        Solution s = new Solution() ;
        int[] ans = s.searchRange(arr, target) ;
        System.out.println("First Pos:"+ans[0]+", Last Pos: "+ans[1]) ;
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0 ;
        int r = nums.length - 1 ;

        int start = searchStart(nums, l, r, target) ;                       // finding start position of number in array
        int end = searchEnd(nums, l, r, target, start) ;                    // finding end position of number in array
        int[] pos = new int[] {start, end} ;
        return pos ;
    }

    private int searchStart(int[] nums, int l, int r, int target)
    {
        while(l<=r)
        {
            int m = l + (r-l)/2 ;
            if(nums[m] == target)
            {
                if(m==0 || nums[m-1]!=target)                               // if first element is num OR element before mid element is not num
                    return m ;
                else                                                        // There is at least one element before mid which is num
                    r = m-1 ;
            }
            else if(nums[m] < target)                                       // haven't reached target yet
                l = m + 1 ;
            else                                                            // haven't reached target yet
                r = m - 1 ;
        }
        return -1 ;                                                         // num not present
    }

    private int searchEnd(int[] nums, int l, int r, int target, int start)
    {
        if(start == -1)
            return -1 ;
        while(l<=r)
        {
            int m = l + (r-l)/2 ;
            if(nums[m] == target)
            {
                if(m==nums.length-1 || nums[m+1]!=target)                   // if last element is num OR element after mid element is not num
                    return m ;
                else                                                        // There is at least one element after mid which is num
                    l = m+1 ;
            }
            else if(nums[m] > target)                                       // haven't reached target yet
                r = m - 1 ;
            else                                                            // haven't reached target yet
                l = m + 1 ;
        }
        return -1 ;
    }
}

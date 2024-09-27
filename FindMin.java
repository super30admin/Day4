/*
*Space complexity O(1)
* Time Complexity O(logn)
* Find Minimum in rotated array 
* Method : Check if low is less than high in the beginning. If true then it is sorted.
* So return low element. Else perform binary search
*/
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int min = Integer.MIN_VALUE;
        while(low <= high)
        {
            int mid = (low + (high-low)/2);
            if (nums[low] <= nums[high])
            {
                min = nums[low];
                return min;
            }
            if (nums[low] > nums[mid] )
            {
                high = mid;
            }
            else
            {
                low = mid + 1;
            }
        }
        return min;
    }
}

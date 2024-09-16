/* 

Big O : Time: O(log N) and Space O(1)

Passed All Test Cases 

Using Binary Search, we shift the either of low or high pointer to the side where the element adjacent to mid is greater. 
This gives us the peak element. Our base case is when element at mid is greater than both its prev and next element. 


*/


class Solution {
    public int findPeakElement(int[] nums) {
      if (nums.length == 0 || nums == null) return -1 ; 
        int low = 0 ; 
        int high = nums.length - 1 ; 
        while (low <= high) {
            int mid = low + (high - low) / 2 ; 
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1]))
                return mid ; 
            else if (mid > 0 && nums[mid] < nums[mid - 1])
                high = mid - 1 ; 
            else
                low = mid + 1 ; 
        }
        
        return -1 ; 
    }
}
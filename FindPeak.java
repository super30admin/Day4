/**
Time complexity: O(log n)
Space complexity: O(1)
Executed on Leetcode? Yes
Any problems faced? No
*/
class FindPeak {
    /**
    Approach:
    - Though the array is not sorted, we use a binary search approach.
    - Check if element at mid < element at mid+1. If so, set low to mid+1
    - If not, set high to mid-1.
    - We return the mid when:
        * mid reached the beginning of the array OR mid element > mid-1 element
        * AND
        * mid has reached the end of the array OR mid element > mid+1 element     
    */
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(((mid == 0) || nums[mid] > nums[mid-1]) && ((mid == nums.length-1) || nums[mid] > nums[mid+1])) {
                return mid;
            } else if (nums[mid] < nums[mid+1]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}

/**
Time complexity: O(log n)
Space complexity: O(1)
Successfully executed on Leetcode? Yes
Any problems faced? No
*/
class FindMinArray {
    /**
    Approach:
    - Find the mid as we do for binary search.
    - Check if mid<high, then move to the right (low=mid+1)
    - Else, move to the left (high=mid-1)
    - We return the nums[mid] when:
        * mid reached the beginning of the array OR mid element < mid-1 element
        * AND
        * mid has reached the end of the array OR mid element < mid+1 element
    */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            
            if(((mid==0) || nums[mid]<nums[mid-1]) && ((mid==nums.length-1) || nums[mid] < nums[mid+1])) {
                return nums[mid];
            }
            else if(nums[mid] > nums[high]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }
}

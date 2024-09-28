// Time Complexity: O(log n) where n is the number of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


// Your code here along with comments explaining your approach
class FindMinRotatedSortedArray {
    public int findMin(int[] nums) {
        //base case
        if(nums == null || nums.length == 0){
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        //binary search for min element
        while(low<=high) {
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low + (high-low)/2;

            //if mid is lesser than previous and next element, then it is the min element
            //edge cases min could be 0 or nums length
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length -1 || nums[mid] < nums[mid+1])) {
                return nums[mid];
            } else if(nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
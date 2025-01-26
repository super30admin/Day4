// Time Complexity: O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Binary Search - Find the mid element and check if it is the minimum element. If not, check if the mid element is greater than the low element, then move to the right side of the array else move to the left side of the array.

class MinRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;

        while(low <= high){
            if(nums[low] <= nums[high]){
                return nums[low];
            }

            int mid = low + (high-low)/2;

            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }else if(nums[mid] >= nums[low]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}

// Time Complexity: O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Binary Search - Find the mid element and check if it is the peak element. If not, check if the mid element is greater than the mid+1 element, then move to the left side of the array else move to the right side of the array.

class FindPeakElem {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1;
        int n = nums.length;

        while(low <= high){
            int mid = low + (high-low)/2;

            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid+1])){
                return mid;
            }else if(nums[mid+1] > nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return -1;
    }
}

//This solution uses binary search to find out the min element.
// As the array is a rotated sorted array if we can find the element at which it is rotated we can easily find out the min element
//TimeComplexity: O(log n) since we used binary search
// Space complexity: O(1) Since we haven't used any new datastructures that grows in size with respect to input data
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else
                high = mid;
        }
        return nums[low];
    }
}
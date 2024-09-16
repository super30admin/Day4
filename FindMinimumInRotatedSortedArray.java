class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            //if the array is sorted, means left element is less than right element, we will return element at left index.
            if(nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left)/2;
            //if the element mid is less than the element at the its left and the element at its right, we have got our minimum element
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length -1 || nums[mid + 1] > nums[mid])) {
                return nums[mid];
            }
            //left side is sorted, so we will move right
            else if(nums[left] <= nums[mid]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
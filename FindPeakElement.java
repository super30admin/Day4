class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            //if the element at mid is greather than its left element and right element, it is the peak element.
            if((mid  == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }
            //if the element at mid is smaller than its immediate left element, move left as the peak might be on the left side.
            else if(mid != 0 && nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            }
            //else move right
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
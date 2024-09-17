/**
 * time complexity is O(logn)
 * space complexity is O(1)
 * leetcode test cases - pass
 */

class Solution {
    public int findMin(int[] nums) {
        int left = 1;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            if(nums[mid] < nums[0]) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return nums[0];
    }
}
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class FindFristAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findStartIndex(nums, target);
        result[1] = findEndIndex(nums, target);
        return result;

    }

    public int findStartIndex(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }

            if(nums[mid] == target) {
                index = mid;
            }
        }

        return index;

    }
    public int findEndIndex(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }

            if(nums[mid] == target) {
                index = mid;
            }
        }

        return index;
    }
}

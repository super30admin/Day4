/*
Time Complexity : log(n) + log(n) , so total 2log(n) which is log(n).
space Complexity:  O(1)
yes, worked on leetcode

*/

class Solution_first_last {
    public int[] searchRange(int[] nums, int target) {

        // creted one result array to return the starting and ending index of target.

        int result_array[] = { -1, -1 };

        int start_index = 0;
        int end_index = nums.length - 1;
        // checking left side target
        while (start_index <= end_index) {

            int mid = start_index + (end_index - start_index) / 2;

            if (nums[mid] == target) {
                result_array[0] = mid;
                end_index = mid - 1;
            } else if (nums[mid] > target) {

                end_index = mid - 1;
            } else {
                start_index = mid + 1;
            }

        }

        start_index = 0;
        end_index = nums.length - 1;

        // checking right side target

        while (start_index <= end_index) {

            int mid = start_index + (end_index - start_index) / 2;

            if (nums[mid] == target) {

                result_array[1] = mid;
                start_index = mid + 1;
            } else if (nums[mid] > target) {
                end_index = mid - 1;
            } else {
                start_index = mid + 1;
            }
        }
        return result_array;
    }
}

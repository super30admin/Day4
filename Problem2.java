class Solution {
    public int findMin(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int first = 0;
        int last = nums.length - 1;

        if (nums[last] > nums[first]) {
            return nums[0];
        }

        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }

        return Integer.MAX_VALUE;
    }
}
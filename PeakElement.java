//O(log n)
//O(1)
//Leetcode : Yes


public class PeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right) {
            mid = left + (right - left)/2;

            if (nums[mid] > nums[mid + 1]) {
                //meaning left side of the array can have peak
                right = mid;
            } else {
                left = mid +1;
            }
        }
        return left;
    }
}

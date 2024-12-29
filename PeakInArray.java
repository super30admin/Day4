//TC:O(log n) as single binary search
//SC:O(1) no extra space used, just n to save array
//approach: binary search, if mid > mid+1, peak must be on left side, including mid, else go to right side

public class PeakInArray {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

// Time Complexity : O(logn)
// Space Complexity : O(1)

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println("Index of Peak Element : " + findPeakElement(nums));
    }
}

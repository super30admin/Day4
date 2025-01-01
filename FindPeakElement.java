// Time Complexity: 0(log n)
// Space Complexity: 0(1) as no data structure has been utilized

// In the else if condition, as per Raj's explanation right element
// is compared with mid, if true then high and low are updated.
//In my code, I checked for left and mid and updated the low and high accordingly.

public class FindPeakElement {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] { 1, 2, 3, 1 })); // 2
        System.out.println(findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 })); // 5
        System.out.println(findPeakElement(new int[] { 1, 2 })); // 1
    }

    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == low || nums[mid] > nums[mid - 1]) && (mid == high || nums[mid] > nums[mid + 1]))
                return mid;
            else if (mid != 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

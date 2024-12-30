import java.util.Arrays;

// Time Complexity: 0(log n)
// Space Complexity: 0(1)

// Implementing separate binary searches for first and last elements
public class FindFirstandLastPositionofElementinSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 8, 10 }, 8))); // [3,5]
        System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 8, 10 }, 9))); // [-1,-1]
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] { -1, -1 };
        if (target < nums[0] && target > nums[0])
            return new int[] { -1, -1 };
        int first = findFirst(nums, target);
        if (first == -1)
            return new int[] { -1, -1 };
        int last = findLast(nums, target);
        return new int[] { first, last };
    }

    private static int findFirst(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                // If Left element of mid is not same as mid then return mid otherwise update
                // high
                if (mid == 0 || nums[mid - 1] != nums[mid])
                    return mid;
                high = mid - 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int findLast(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                // If right element of mid is not same as mid then return mid otherwise update
                // low
                if (mid == n - 1 || nums[mid] != nums[mid + 1])
                    return mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}

import java.util.Arrays;

public class FirstLastInSortedArray {
    public static int first(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == low || nums[mid - 1] < nums[mid])
                    return mid;
                else
                    high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return -1;
    }

    public static int second(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == high || nums[mid + 1] > target)
                    return mid;
                else
                    low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = first(nums, 0, nums.length - 1, target);
        int right = second(nums, 0, nums.length - 1, target);
        return new int[] { left, right };
    }

    public static void main(String[] args) {
        int arrayToSearch[] = { 5, 7, 7, 8, 8, 10 }, target1 = 8;
        int arrayToSearch2[] = { 5, 7, 7, 8, 8, 10 }, target2 = 6;
        int arrayToSearch3[] = {}, target3 = 0;
        int result[] = searchRange(arrayToSearch, target1);
        int result2[] = searchRange(arrayToSearch2, target2);
        int result3[] = searchRange(arrayToSearch3, target3);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
    }

}
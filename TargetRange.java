import java.util.Arrays;

class TestRange {

    int low = -1;
    int high = -1;

    public int[] searchRange(int[] nums, int target) {
        low = -1;
        high = -1;
        int l = 0;
        int h = nums.length - 1;
        if (nums.length > 0) {
            if (nums[0] == target && nums[nums.length - 1] == target) {
                high = nums.length - 1;
                low = 0;
            } else
                binarySearch(nums, l, h, target);
        }

        int[] result = { low, high };
        return result;
    }

    public void binarySearch(int[] arr, int l, int h, int target) {

        int pivot = l + (h - l) / 2;

        if (l <= h) {
            if (arr[pivot] == target) {
                // for low index of the range

                if (pivot > l) {
                    if (arr[pivot - 1] == target) {
                        low = pivot - 1;
                        if (pivot - 1 > l) {
                            binarySearch(arr, l, pivot - 2, target);
                        }
                    } else {
                        low = pivot;
                    }
                } else {
                    low = pivot;
                }

                // for high index of the range
                if (pivot < h) {
                    if (arr[pivot + 1] == target) {
                        high = pivot + 1;
                        if (pivot + 1 < h) {
                            binarySearch(arr, pivot + 2, h, target);
                        }
                    } else {
                        high = pivot;
                    }
                } else {
                    high = pivot;
                }

            } else if (target < arr[pivot]) {
                binarySearch(arr, l, pivot - 1, target);
            } else {
                binarySearch(arr, pivot + 1, h, target);
            }
        }
    }

    public static void main(String[] args) {
        TestRange tr = new TestRange();
        int[] num1 = { 5, 7, 7, 8, 8, 10 };
        int[] num2 = { 1, 3 };
        int[] num3 = { 55 };
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 8, 10, 10 };
        int[] nums5 = {};
        System.out.println(Arrays.toString(tr.searchRange(nums, 4)));
        System.out.println(Arrays.toString(tr.searchRange(num1, 7)));
        System.out.println(Arrays.toString(tr.searchRange(num2, 1)));
        System.out.println(Arrays.toString(tr.searchRange(num2, 3)));
        System.out.println(Arrays.toString(tr.searchRange(num3, 55)));
        System.out.println(Arrays.toString(tr.searchRange(num3, 5)));
        System.out.println(Arrays.toString(tr.searchRange(nums5, 5)));
        System.out.println(Arrays.toString(tr.searchRange(nums, 0)));

    }
}
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int start = getPosition(nums, target, true);
        int end = getPosition(nums, target, false);

        return new int[] { start, end };

    }

    public int getPosition(int[] arr, int t, boolean start) {
        int first = 0;
        int last = arr.length - 1;

        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (arr[mid] == t) {

                if (start) {
                    if (mid == 0 || arr[mid - 1] != t) {
                        return mid;
                    } else {
                        last = mid - 1;
                    }
                } else {
                    if (mid == arr.length - 1 || arr[mid + 1] != t) {
                        return mid;
                    } else {
                        first = mid + 1;
                    }
                }

            } else if (arr[mid] < t) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return -1;
    }
}
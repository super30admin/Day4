// Time complexity: O(log n)
//Space complexity: O(1)
class P1 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int positions[] = new int[] { -1, -1 };
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    positions[0] = mid;
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (positions[0] == -1) {
            return positions;
        }
        start = positions[0];
        end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    positions[1] = mid;
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return positions;
    }
}
//Time Complexity: O(log(n))
//Space Complexiy: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length == 0)
            return new int[] { -1, -1 };

        int[] res = new int[] { -1, -1 };
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target)
                break;

            else if (nums[mid] < target)
                l = mid + 1;

            else
                r = mid - 1;
        }

        if (l > r)
            return res;

        while (nums[l] != target)
            l++;
        res[0] = l;

        while (nums[r] != target)
            r--;
        res[1] = r;

        return res;

    }
}
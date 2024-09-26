// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package binary2;

public class FirstLastMatrix {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //to negate chances of integer overflow error
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res[0] = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (res[0] != -1) {
            int i = res[0];
            while (i < nums.length && nums[i] == target) {
                i++;
            }
            res[1] = i - 1;
        }
        return res;
    }
}

/*
    1. Time Complexity : O(log(n))
    2. Space Complexity : O(1)   
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */

/*
 * Perform two binary searches, one to find the starting position of the target
 * and another to find the last position.
 */

public class FirstAndLastPosInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int l = 0, h = nums.length - 1, mid;
        int[] ans = {-1, -1};
        while (l <=h) {
            mid = l + (h -l) / 2;
            if (nums[mid] == target) {
                    ans[0] = mid;
                    h = mid - 1;
            } else if (nums[mid] < target)
                l = mid + 1;
            else
                h = mid - 1;
        }
        l = 0; h = nums.length - 1;
        while (l <=h) {
            mid = l + (h -l) / 2;
            if (nums[mid] == target) {
                    ans[1] = mid;
                    l = mid + 1;
            } else if (nums[mid] < target)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2,2,2,3,4,5,6,6};
        int[] targets = {1,2,5,6,0,7};
        int[] pos;
        for (int target : targets) {
            pos = searchRange(nums, target);
            System.out.println("Target: "+ target + " starting index:" + pos[0] + " last index:" + pos[1]);
        }
    }
}

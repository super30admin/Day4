/* Time complexity: O(log n)
 * Space Complexity: O(1)
 * Ran successfully on LeetCode: Yes
 */

import java.util.Arrays;
public class FirstNLastElement {
    public static int[] searchRange(int[] nums, int target) {

        // Base Case
        if (nums.length == 0 || nums == null) return new int[]{-1, -1};

        if (target < nums[0] || target > nums[nums.length - 1]) return new int[]{-1,-1};

        int first = firstBinarySearch(nums, target);

        if (first == -1) {
            return new int[]{-1,-1};
        }

        int second = secondBinarySearch(nums, target);

        return new int[]{first, second};
    }

    public static int firstBinarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) { 
                if (mid == 0 || nums[mid] > nums[mid-1]) {
                    return mid; 
                } else {
                    high = mid - 1;
                }
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int secondBinarySearch(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) { 
                if (mid == nums.length - 1 || nums[mid] < nums[mid+1]) {
                    return mid; 
                } else {
                    low = mid + 1;
                }
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] solution = searchRange(nums, 8);
        System.out.println(Arrays.toString(solution));
    }    
}

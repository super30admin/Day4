// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Problem1 {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int[] indices = new int[2];
        indices[0] = -1;
        indices[1] = -1;
        if (nums == null || nums.length == 0)
            return new int[] { -1, -1 };
        if (nums[0] > target || nums[nums.length - 1] < target)
            return new int[] { -1, -1 };
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println("mid " + mid);
            if (nums[mid] == target) { // Once we find the mid, we've got to find the first index
                if (mid == 0 || nums[mid] > nums[mid - 1]) {
                    indices[0] = mid;
                    break;
                } else if (nums[mid] > nums[mid - 1]) {
                    indices[0] = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            } else if (target < nums[mid]) {
                high = mid - 1;
                System.out.println("high" + high);
            } else {
                low = mid + 1;
                System.out.println("low" + low);
            }
        }
        if (indices[0] == -1)
            return indices;

        int lowLast = 0; // finding the right index
        int highLast = nums.length - 1;
        while (lowLast <= highLast) {
            int mid = lowLast + (highLast - lowLast) / 2;
            if (nums[mid] == target) { // Once we find the mid, we've got to find the first index
                if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    indices[1] = mid;
                    break;
                } else {
                    lowLast = mid + 1;
                }
            } else if (target < nums[mid])
                highLast = mid - 1;
            else
                lowLast = mid + 1;
        }
        return indices;
    }
}
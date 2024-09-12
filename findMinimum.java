// Time Complexity : Since we are dividing the search space in half o(Log(n)) where n is the length of the array
// Space Complexity : O(1) since we need just the mid l and r pointers and no search space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class findMinimum {
    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1) {
            return nums[0];
        }
        int mid = 0;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            mid = l + (h - l) / 2;

            // we check if tht index is not out of bounds as well as the base condition that
            // num[mid] <num[mid-1]
            // which tell us that this is the pivot element
            if (mid != 0 && nums[mid] < nums[mid - 1])
                return nums[mid];

            // else do the regular binary to remove unnecessary search space
            else if (nums[mid] > nums[h])
                l = mid + 1;
            else
                h = mid - 1;
        }

        // returning mid as we are sure it will never go out of bounds
        return nums[mid];

        // https://www.youtube.com/watch?v=IzHR_U8Ly6c

    }
}
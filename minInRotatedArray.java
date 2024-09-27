// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {
    private static int findMin(int[] nums, int target) {

        // inlialze the value of l and r
        int l = 0;
        int r = nums.length - 1;

        // if length of the array is less than 2 then return 0th index element
        if (nums.length <= 1)
            return nums[0];

        // if left most element is less then rigth most element that means array is
        // alredy sorted so we return element on 0th index
        if (nums[l] < nums[r])
            return nums[0];

        // to get the index of the pivot element we are using binary search method but
        // little diffrently
        while (l <= r) {

            // find the mid element
            int mid = l + (r - l) / 2;

            // if mid element is greater then mid +1's element then we found our pivot
            // element and return that element
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] < nums[l]) {
                // else if mid element is less then that means our pivot element is in first
                // half so,
                r = mid - 1;
            } else {
                // else our pivot element in second half so,
                l = mid + 1;
            }

        }

        // return 0th element as our base case.
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println("min element is: " + findMin(nums, target));
    }

}
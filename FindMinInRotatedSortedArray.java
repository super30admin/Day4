/**
 * Time complexity: O(logN)
 * Space complexity: O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : no
 */
public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        // If the array is already sorted, the first element is the minimum
        if (nums[low] <= nums[high]) {
            return nums[low];
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // Minimum must be in the right part
                low = mid + 1;
            } else {
                // Minimum is in the left part
                high = mid;
            }
        }

        // At the end low will point to the minimum element
        return nums[low];
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,-1,1,2};
        FindMinInRotatedSortedArray obj = new FindMinInRotatedSortedArray();
        int min = obj.findMin(arr);
        System.out.println("Minimum is: " + min);
    }
}


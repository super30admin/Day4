/**
 * Time complexity: O(logN)
 * Space complexity: O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : no
 */
public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // In a sorted array minimum is at lowest index
            if (nums[low] <= nums[high])
                return nums[low];
            int mid = low + (high - low)/2;
            // check if mid is smaller than its neighbors
            if ((mid == low || nums[mid] <= nums[mid - 1]) && (mid == high || nums[mid] <= nums[mid + 1]))
                return nums[mid];

            if (nums[mid] < nums[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,-1,1,2};
        FindMinInRotatedSortedArray obj = new FindMinInRotatedSortedArray();
        int min = obj.findMin(arr);
        System.out.println("Minimum is: " + min);
    }
}


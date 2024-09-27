
public class FindMinimumInRotatedSortedArray {
    /*
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     *
     * To find the minimum or smallest element in an sorted array pivoted at a certain index
     *
     * Author: Aditya Mulik
     */

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int solution = findMin(nums);
        System.out.println(solution);
    }

    public static int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            // Base Case
            if (nums[low] <= nums[high]) {
                return nums[low];
            }

            int mid = low + (high - low) / 2;

            if ((mid==0 || nums[mid] < nums[mid-1]) && (mid==nums.length-1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if (nums[low] <= nums[mid]) {
                // left side of the array is sorted
                low = mid + 1;
            } else if (nums[high] >= nums[mid]) {
                // right side of the array is sorted
                high = mid - 1;
            }
        }

        return Integer.MAX_VALUE;
    }
}
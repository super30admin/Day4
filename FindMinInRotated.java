// Time complexity: O(log n)
// Space complexity: O(1)
public class FindMinInRotated {

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int low = 0;
        int high = nums.length - 1;

        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < min) {
                min = nums[mid];
            }else if(nums[mid] < nums[high]) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }

        }
        return min;
    }
}

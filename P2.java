// Time complexity: O(log n)
//Space complexity: O(1)
public class P2 {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = start + ((end - start) / 2);
        while (nums[start] > nums[end]) {
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
            mid = start + ((end - start) / 2);
        }
        return nums[start];
    }
}

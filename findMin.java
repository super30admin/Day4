
public class findMin {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;

		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[low] <= nums[high])
				return nums[low];
			if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
				return nums[mid];
			} else if (mid > 0 && nums[mid] <= nums[high]) {
				high = mid - 1;// move towards the side which is unsorted

			} else {
				low = mid + 1;

			}

		}
		return -1;
	}

	public static void main(String[] args) {
		findMin min = new findMin();
		int[] nums = { 3, 4, 5, 1, 2 };

		System.out.println(min.findMin(nums));
	}
}

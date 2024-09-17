

public class MinRotatedArray {

	boolean isRec = true;

	public int findMin(int nums[], int low, int high) {
		if (low <= high) {
			if (nums[low] < nums[high])
				return nums[low];

			int mid = low + (high - low) / 2;
			if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1]))
				return nums[mid];
			else if (nums[low] <= nums[mid]) {
				return findMin(nums, mid + 1, high);

			} else {
				return findMin(nums, low, mid - 1);

			}
		}
		return -1;
	}

	public int findMinIter(int nums[]) {
		if (nums == null || nums.length == 0)
			return -1;
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			if (nums[low] < nums[high])
				return nums[low];

			int mid = low + ((high - low) / 2);
			if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1]))
				return nums[mid];
			else if (nums[low] <= nums[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public int findMin(int[] nums) {
		if (isRec)
			return findMin(nums, 0, nums.length - 1);
		return findMinIter(nums);

	}

	public static void main(String[] args) {
		int[] nums = { 1 };

		MinRotatedArray min = new MinRotatedArray();
		int index = min.findMin(nums);
		
	}
}

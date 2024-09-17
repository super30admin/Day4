public class PeakElement {

	boolean isRec = true;

	public int peakElement(int nums[], int low, int high) {
		if (low <= high) {
			int mid = low + ((high - low) / 2);

			if ((mid == 0 || nums[mid] >= nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] >= nums[mid + 1]))
				return mid;
			else if (mid > 0 && nums[mid - 1] > nums[mid])
				return peakElement(nums, low, mid - 1);
			else
				return peakElement(nums, mid + 1, high);
		}
		return -1;
	}

	public int findPeakIter(int nums[]) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || nums[mid] >= nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] >= nums[mid + 1]))
				return mid;
			else if (mid > 0 && nums[mid - 1] > nums[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		if (!isRec)
			return findPeakIter(nums);
		return peakElement(nums, 0, nums.length - 1);
	}

	public static void main(String args[]) {
		PeakElement ele = new PeakElement();

		int arr[] = { 1, 2 };
		int index = ele.findPeakElement(arr);
		System.out.println(index);
	}
}

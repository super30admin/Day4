public class FindMinInRotatedSortedArray {

	public int findMin(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return -1;
		}
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high-low)/2;
			if (nums[low] < nums[high]) {
				return nums[low];
			}
			if((mid == 0 || nums[mid]<nums[mid-1])&& (nums.length-1 == mid || nums[mid]<nums[mid+1])) {
				return nums[mid];
			}
			else if (nums[mid]<nums[low]) {
				high = mid-1;
			}
			else {
				low = mid +1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 3,4,5,1,2 };
		FindMinInRotatedSortedArray findMinInRotatedSortedArray = new FindMinInRotatedSortedArray();
		findMinInRotatedSortedArray.findMin(nums);

	}
}

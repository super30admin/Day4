public class FindingThePeakElement {

	public int findPeakElement(int[] nums) {
		if (nums.length==0 || nums == null) {
			return -1;
		}
		int low = 0;
		int high = nums.length-1;
		while (low <=high) {
			int mid = low + (high-low)/2;
			if ((nums.length-1 == mid || nums[mid]>nums[mid+1]) && (mid==0 || nums[mid]> nums[mid-1])) {
				return mid;
			}
			else if (mid >0 && nums[mid]< nums[mid-1]) {
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		FindingThePeakElement findingThePeakElement = new FindingThePeakElement();
		int [] nums = {1,2,1,5,4,6,4};
		findingThePeakElement.findPeakElement(nums)
	}

}

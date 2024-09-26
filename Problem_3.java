
//Time Complexity :O(logn)
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes

/*
* Your code here along with comments explaining your approach : 
* I have used binary search and compared mid element with mid-1 and mid+1 element.
* Using this, I have moved low and high pointers.
*/
public class PeakElement {

	public static void main(String[] args) {
		int nums[] = new int[] { 2, 1 };
		System.out.println(peakElement(nums));
	}

	private static int peakElement(int[] nums) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
				return nums[mid];
			} else if (mid == nums.length - 1 || nums[mid + 1] > nums[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

}

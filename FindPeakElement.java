// Time Complexity: O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
package Interview;

public class FindPeakElement {

	public static void main(String[] args) {
		int[] nums = {6,5,4,3,2,3,2};
		System.out.println(findPeakElement(nums));

	}
	
	public static int findPeakElement(int[] nums) {
		if(nums.length == 0 || nums == null) {
			return -1;
		}
		int low = 0 ;
		int high = nums.length-1;
		int n = nums.length;
		
		while(low <= high) {
			int mid = low + (high-low)/2;
			if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid+1])) {
//			(mid == low || nums[mid] > nums[mid-1]) && (mid == high || nums[mid] > nums[mid+1])
				return mid;
			}else if(nums[mid+1] > nums[mid]) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		
		return 678;
	}
}

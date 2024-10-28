/*
TC - O(logn)
SC - O(1)
Approach - We are moving towards a higher slope. So we compare the mid with mid-1 and mid+1 if it is the
peak then return. Else we move towards the higher neighbor
 */


/**
 * PeakElement : PeakElement
 *
 * @author : Kavya Mandaliya (kmandali@cisco.com)
 * @version : 1.0 (Oct 28, 2024)
 * @since : 1.0 (Oct 28, 2024)
 */
public class PeakElement {
	public int findPeakElement(int[] nums) {
		if(nums.length <= 1) return 0;
		int low = 0, high = nums.length-1;
		while(low <= high){
			int mid = low + (high-low)/2;
			if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])) return mid;
			else if(mid > 0 && nums[mid] < nums[mid-1]) high = mid-1;
			else{
				low = mid+1;
			}
		}
		return -1;
	}
}

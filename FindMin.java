/*
TC - O(log n)
SC - O(1)
Approach - the main idea is that the min always lies in the unsorted half of the array,
Or at the mid itself. So we search in the unsorted half by comparing mid to low and high
It can also be a sorted array, then low would the min

 */


/**
 * FindMin : FindMin
 *
 * @author : Kavya Mandaliya (kmandali@cisco.com)
 * @version : 1.0 (Oct 28, 2024)
 * @since : 1.0 (Oct 28, 2024)
 */
public class FindMin {
	public int findMin(int[] nums) {
		int low = 0, high = nums.length-1;
		while(low <= high){
			int mid = low + (high-low)/2;
			if(nums[low] < nums[high]) return nums[low];
			if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])){
				return nums[mid];
			}else if(nums[mid] < nums[high]){
				high = mid -1;
			}else{
				low = mid + 1;
			}
		}
		return -1;
	}
}

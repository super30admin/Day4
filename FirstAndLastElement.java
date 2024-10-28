//TC - O(Log n)
//SC - O(1)
//Approach - using binary search algorithm, we search the array to find the target, once we find it we
//compare it with the previous element to check if thats the first occurence
//for the second binary search we call it from the first to n-1, and once we find the target we check if its the
//last occurrence by comparing the next element.

/**
 * FirstAndLastElement : FirstAndLastElement
 *
 * @author : Kavya Mandaliya (kmandali@cisco.com)
 * @version : 1.0 (Oct 28, 2024)
 * @since : 1.0 (Oct 28, 2024)
 */
public class FirstAndLastElement {
	public int[] searchRange(int[] nums, int target) {
		int n = nums.length;
		int first = binarySearch1(nums, target, 0, n-1);
		if(first == -1) return new int[]{-1,-1};
		int last = binarySearch2(nums, target,first,n-1);
		return new int[]{first, last};
	}
	
	int binarySearch1(int[] nums, int target, int low, int high){
		while(low <= high){
			int mid = low + (high - low)/2;
			if(nums[mid] == target){
				if(mid == low ||  nums[mid-1] != nums[mid]) return mid;
				else high = mid - 1;
			}else if(nums[mid] < target){
				low = mid + 1;
			}else{
				high = mid - 1;
			}
		}
		return -1;
	}
	
	int binarySearch2(int[] nums, int target, int low, int high){
		while(low <= high){
			int mid = low + (high - low)/2;
			if(nums[mid] == target){
				if(mid == high || nums[mid+1] != nums[mid]) return mid;
				else low = mid + 1;
			}else if(nums[mid] < target){
				low = mid + 1;
			}else{
				high = mid - 1;
			}
		}
		return -1;
	}
	
}

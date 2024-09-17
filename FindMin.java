
public class FindMin {
	public static void main(String[] args) {
		int[] nums = {11,2,3,4,5,6,7,8};
		int ans = findMin(nums);
		System.out.println(ans);
	}
	private static int findMin(int[] nums) {
		if(nums.length == 0) return -1;
		if(nums.length == 1) return nums[0];
		
		int low = 0, high = nums.length-1;
		while(low <= high) {
			int mid = low + (high - low)/2;
			if(low < mid && nums[mid]<nums[mid-1]) {
				return nums[mid];
			}
			else if(high > mid && nums[mid+1] < nums[mid]) {
				return nums[mid+1];
			}
			else if(nums[high] > nums[mid]) {
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		return -1;
	}
	

}

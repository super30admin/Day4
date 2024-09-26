// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class Problem_2 {
	
    public int findMin(int[] nums) {
	
		int low = 0;
		int high = nums.length-1;
		int mid = 0;
	 	while (nums[low] > nums[high]){
				mid = low + (high - low)/2 ;
				if(mid != 0 && nums[mid-1] > nums[mid] ) {
					return nums[mid];
				}
				if (mid != nums.length-1 && nums[mid+1] < nums[mid]) {
					return nums[mid+1];
				}
	
				if(nums[mid] > nums[low]) {
					low = mid + 1;
				}else {
					high = mid ;
				}
			}
		return nums[low];
    }
}

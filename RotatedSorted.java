//Space Complexity: O(1)
//Time Complexity: O(logn)

public class RotatedSorted {
	public int findMin(int[] nums) {
		  if (nums == null || nums.length == 0) {
	            return -1;
	        }
	        int start = 0, end = nums.length-1;
	        while (start <= end) { 
	             if (nums[start] < nums[end]) {
	                return nums[start];
	             }

	            int mid = start + (end-start)/2;
	            if ((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])) {
	                return nums[mid];
	            }
	            else if (nums[start] <= nums[mid]) {
	                
	                start = mid+1;                
	            } else {
	                
	                end = mid-1;
	            }   
	        }

	        return -1;
	   }
}


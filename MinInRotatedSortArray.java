package BinarySearch1;

public class MinInRotatedSortArray {
	public int findMin(int[] nums) {
	    if (nums.length == 1) {
	      return nums[0];
	    }

	    // initializing left and right pointers.
	    int left = 0, right = nums.length - 1;

	    if (nums[right] > nums[0]) {
	      return nums[0];
	    }
	    
	    // Binary search 
	    while (right >= left) {
	      // Find the mid element
	      int mid = left + (right - left) / 2;

	      if (nums[mid] > nums[mid + 1]) {
	        return nums[mid + 1];
	      }

	      if (nums[mid - 1] > nums[mid]) {
	        return nums[mid];
	      }

	      if (nums[mid] > nums[0]) {
	        left = mid + 1;
	      } else {
	        right = mid - 1;
	      }
	    }
	    return -1;
	  }

}

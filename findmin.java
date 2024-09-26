package binarysearch;
//Space complexity O(1)
// Time Complexity O(logn)


public class findmin {
	
	    public int findMin(int[] nums) {
	        int low = 0, high = nums.length-1;
	        int min = Integer.MIN_VALUE;
	        while(low <= high)
	        {
	            int mid = (low + (high-low)/2);
	            if (nums[low] <= nums[high])
	            {
	                min = nums[low];
	                return min;
	            }
	            if (nums[low] > nums[mid] )
	            {
	                high = mid;
	            }
	            else
	            {
	                low = mid + 1;
	            }
	        }
	        return min;
	    }
	    }

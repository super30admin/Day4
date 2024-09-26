package binarysearch;
//Time complexity is O(logn). 
//Space complexity is O(1)
public class findpeak {
       public int findPeakElement(int[] nums) {
	        int low = 0, high = nums.length-1;
	         int peak = Integer.MIN_VALUE;
	         while(low <= high) {
	             int mid = low + (high - low)/2;
	             if (((mid - 1 < 0 ) || nums[mid] > nums[mid-1]) && ((mid + 1 > nums.length-1) || nums[mid] > nums[mid+1]))
	             {
	                 peak = mid;
	                 return peak;
	             }
	             else if ((mid - 1 < 0 ) || nums[mid] < nums[mid+1])
	             {
	                 low = mid +1;
	             }
	            else  if ((mid + 1 > (nums.length-1) ) || nums[mid] < nums[mid-1])
	             {
	                 high = mid -1;
	             }
	         }
	         return peak;
	     }
	 }
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* To find the target, if element previous to mid is less than mid and element next to mid is less than mid, can return mid as peak*/
class Solution {
	public static int Find_Peak_Element(int[] nums) {
	int low = 0;
	int high = nums.length -1;
	            
	while(low <= high){
		int mid = low + (high-low)/2;
		
		//if element previous to mid is less than mid and element next to mid is less than mid, can return mid as peak
	    if((mid==0 || nums[mid-1] < nums[mid]) && (mid == nums.length-1 || nums[mid+1]<nums[mid]))
	    	return mid;
	    else if(mid > 0 && nums[mid] < nums[mid-1])		// if mid is less than previous element, then move the mid to first subarray
	    	high = mid-1;
	     else
	    	 low = mid +1;								//else move the mid to second subarray
	    }
	return -1;
	}
	public static void main(String[] args) {
		int nums[] = {1,2,1,3,5,6,4};
		int peak = Find_Peak_Element(nums);
		System.out.println("Peak is " +peak);
	}
}


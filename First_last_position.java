//Time Complexity: O(log N) where N represents the number of element in the array
//Space Complexity: O(1)  since we are not using any extra data structure to store values
//the code executed on the Leetcode

/* This is a modified binary search, to find the first index, we use a boolean value to move to the left most element of the array using left boolean value.
 * We have left set as true so that we can move to extreme left of the array for the same target value. Also, we check if the target is less than middle element,
 * if the target is lesser, we restrict our search to left side of array(array before mid element). 
 * To find the last index, we set the left boolean value as false since we do not want to restrict our search when we find the start index of element, 
 * Also, reduce the index by 1 since it will reach the one extra index after the search for last element.
 * */

public class First_last_position {
	
	public static int findindex(int[] nums, int target, boolean left) {
		
		int st = 0;
		int end = nums.length-1;
		while(st<end) {
			int mid = st + (end-st)/2;			
			if(target<nums[mid] || (left && target==nums[mid]))
				end = mid;
			else st = mid+1;
		}
		return st;		
	}
	
	public static int[] search_rotated(int[] nums, int target) {
		
		int[] resin = {-1, -1};
		int leftin = findindex(nums, target, true);
		if(leftin == nums.length || target!= nums[leftin])
			return resin;
	
		resin[0] = leftin;
		resin[1] = findindex(nums, target, false)-1;
		return resin;
	}

	
	public static void main(String [] args) {
		
		int[] nums = {4, 5, 6, 7, 8, 8, 5};
		int target = 8;
		int[] res = search_rotated(nums, target);
		System.out.println("The index of first element: " + res[0] +" and last element index: "+ res[1]);
		
	}
}
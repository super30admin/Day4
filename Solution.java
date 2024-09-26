
// Time Complexity : log n
// Space Complexity : n
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :Not completed still working on it. 

// Your code here along with comments explaining your approach

/*34. Find First and Last Position of Element in Sorted Array
 * 
 * 
 * The idea is to find the mid  and check if mid element is == to target
 * then check if the mid -1 element is equal to target
 * if yes then do a binary search on left side of array unitll the mid -1 element  is not 
 * equal to target. 
 * 
 * same logic for right hand side for last occurence
 * 
 * getting some bugs with control flow of the structure so will spend some time later to fix it.
 * tried to use counter like a flag to control the flow but need to debug it.
 * 
 * 
 * 
 * 
 * */

public class Solution {

	public static int[] searchRange(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;
		int first = -1;
		int last = -1;
		int counter =-1;
		
		int[] a = {first, last};
		while (left <= right) {
			int mid = left + (right - left) / 2;
			System.out.println("while loop");
			if (nums[mid] == target && counter == 1) {
				System.out.println("mid : " + mid);
				first= mid;
				a[0] = first;
				counter = -1;
				
			} 
			
			if (nums[mid] == target && counter == 2) {
				System.out.println("mid : " + mid);
				last = mid;	
				a[1] = last;
				counter =-1;
				return a;
			} 
			
			else if (target == nums[mid-1]) {
				right = mid - 1;
				counter = 1;
				
			}
			else if (target == nums[mid+1]) {
				left = mid + 1;	
				counter = 2;
			}
			else if (target < nums[mid] ) {
				right = mid - 1;
				
			} else {
				left = mid + 1;
			}
		}
		
		
		return a;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2, 2, 3, 4, 6, 8, 8, 8, 8, 8, 8, 8, 10 };
		System.out.println("the returned first occurence val is " + searchRange(arr, 8)[0]);
	}

}







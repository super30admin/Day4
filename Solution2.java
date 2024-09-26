// Time Complexity : log n
// Space Complexity : n
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
 * Find Minimum in Rotated Sorted Array
 * 
 * 
 * still working on this
 * Pseudocode: 
 * take middle of array and in each sub array one side of mid will be sorted
 * take the first element of sorted part and pass it to min
 * then do binary search again on unsorted part divide it into one sorted and unsoted
 * pass first element of sorted to min if its less than min
 * 
 * */

public class Solution2 {

	
	public static int findMin(int[] nums) {

		int min = -1;
		int low = 0;
		int high = nums.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
	
			System.out.println("while loop");
			
			if (nums[mid] <= nums[high]) {
				//right sorted
				System.out.println("low -- "+nums[low]);
				System.out.println("mid -- " + nums[mid]);
				System.out.println( "high -- " +nums[high]);
				min = nums[mid];
				if(min < nums[mid]) {
				min = nums[mid];
				}
				System.out.println("min -- " + min);
				System.out.println();
				high = mid -1;

			} else
				//left sorted
			{
				System.out.println("low : "+nums[low]);
				System.out.println("mid : "+ nums[mid]);
				System.out.println( "high :" +nums[high]);
				if(min < nums[low]) {
				min = nums[low];
				}
				System.out.println("min -- " + min);
				System.out.println();
				low = mid + 1;
			}
			}
		
		return min;
	}
	
	
	public static void main(String[] args) {

		int[] arr = {7,8,9,1,2,3,4,5};
		System.out.println("the returned first occurence val is " + findMin(arr));
	}
	
	
}

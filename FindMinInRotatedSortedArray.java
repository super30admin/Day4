package BinarySearch2;
//Time Complexity : O(logn) for searching using binary search
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//In rotated sorted array one side of the arry is always sorted
//Min element lies in unsorted arry 


public class FindMinInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,1};
		
		int min = findMinimum(nums);
		
		System.out.println(min);
	}
	
	public static int findMinimum(int[] nums) {
		
		int min =0;
		int n = nums.length;
		int low = 0;
		int high = n;
		
        if(nums[0]<=nums[n-1]) return nums[0];
        
		while(low<high) {
			int mid = low + (high-low)/2;
			if(nums[mid]>=nums[0]) {
				low = mid +1;
			}
			else {
				high = mid;
			}
		}
		
		return nums[low];
	}

}

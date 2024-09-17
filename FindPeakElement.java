package BinarySearch2;
//Time Complexity : O(logn) for searching using binary search
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//First find mid element and check if it's greater than prev and next element, if it is then mid is peak
//or, move to the higher side i.e set low to mid+1 or mid-1

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,1};
		
		int peak = findPeak(nums);
		
		System.out.println(peak);
	}

	public static int findPeak(int[] nums) {
		// TODO Auto-generated method stub
		
		if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 0;
        
		
		int peak = 0;
		int n = nums.length;
		int low = 0;
		int high = n-1;
		int mid = 0;
		
		while(low<=high) {
		
			mid = low + (high-low)/2;
			if((mid+1>n-1 || nums[mid] > nums[mid+1]) && (mid-1 <0 || nums[mid] > nums[mid-1]) ){
				peak = mid;				
				return peak;
			}
			else if(nums[mid+1] > nums[mid]) {
				low = mid+1;
			}
			else {
				high = mid-1;
			}
		}
		
		return peak;
	}

}

package BinarySearch2;
//Time Complexity : O(logn) for searching using binary search
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//First, find mid and check with prev element, if it's less than mid is first index OR move high and find first index. Do similar on right part.
//Do binary search 2 times, one for finding first index and other for last index


public class FindFirstAndLastIndexInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,7,7,8,8,10};
		int target = 7;
		
		int[] res = searchRange(nums,target);
		System.out.println(res[0]+":"+res[1]);
	}

	private static int[] searchRange(int[] nums, int target) {
		// TODO Auto-generated method stub
		int[] res = {-1,-1};
		int n = nums.length;
		int low=0;
		int high =n-1;
		int mid=0;
		
		//first index
		while(low<=high) {
			mid = low + (high-low)/2;
			if(nums[mid] < target) {
				low = mid+1;
			}
			else if(nums[mid]> target) {
				high = mid -1;
			}
			else {
				if(mid==0 || nums[mid-1] != target) {
					res[0] = mid;
					break;
				}
				
				high = mid-1;
			}
			
		}
		
		if(res[0] == -1) {
			return res;
		}
		
		//last index
		
		low = mid;
		high = n-1; 
		while(low<=high) {
			mid = low + (high-low)/2;
			if(nums[mid] < target) {
				low = mid+1;
			}
			else if(nums[mid]> target) {
				high = mid -1;
			}
			else {
				if(mid==n-1 || nums[mid+1] != target) {
					res[1] = mid;
					break;
				}
				
				low = mid+1;
			}
		}
		return res;
	}

}

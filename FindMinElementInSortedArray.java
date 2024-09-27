package s30Coding;

//Time Complexity :- findMin (log(n)) worst case :- O(n)

//Space Complexity :- O(1)

// LeetCode execution :- Yes

// Logic :- 	Initially check if it is a sorted array. If yes, return the first element. 
//				Apply BST, find the middle element and check if next element to mid is less than mid,
//				if yes, we found the pivot(min) element, return mid+1.
//				Check if mid is less than its previous element, if yes, we found our pivot(min) at min. return min.
//				Traverse the BST by checking if the first half of the array is sorted or not.


public class FindMinElementInSortedArray {
	     public int findMin(int[] nums) {
	    if (nums == null || nums.length == 0) {
	            return -1;
	        }

	        if (nums.length == 1) {
	            return nums[0];
	        }

	        if (nums[0] <= nums[nums.length - 1]) {
	            return nums[0];
	        }

	        int left = 0;
	        int right = nums.length - 1;

	        while (left <= right) {
	            int mid = left + (right - left) / 2;

	            
	            if(nums[mid+1] < nums[mid]){
	                return nums[mid+1];
	            }
	            if (mid > 0 && nums[mid] < nums[mid - 1]) {
	                return nums[mid];
	            }
	            if (nums[left] <= nums[mid]) {
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }

	        }
	        
	        return -1;
	  }
}

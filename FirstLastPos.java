//Time Complexity : O(logn)
//Space Complexity : O(1)
//Code run successfully on Leetcode.

public class FirstLastPos {
	
public int[] searchRange(int[] nums, int target) {
	
	if(nums.length == 0)
		return new int[] {-1,-1};
 
   int first = binarySearchLeft(nums,target);
   if(first == -1)
	   return new int[] {-1,-1};
   int last = binarySearchRight(nums,target);
   
   return new int[] {first,last};  
    }
   
   public int binarySearchLeft(int[] nums, int target) {
	   
	   int l = 0;
	   int n = nums.length;
	   int h = n - 1;
	   int mid;
	   
	   while(l <= h) {
		   
		   mid = l + (h-l)/2;
		   
		   if(nums[mid] == target) {
			   
			   if(mid == 0 || nums[mid - 1] < nums[mid])
				   return mid;
			   
			   else
				   h = mid -1;
		   }
		   
		   else if(nums[mid] < target)
			   l = mid +1;
		   
		   else
			   h = mid -1;
	   }
	   return -1;
   }
   
   public int binarySearchRight(int[] nums, int target) {
	   
	   int l =0;
	   int n = nums.length;
	   int h = n-1;
	   int mid;
	   
	   while(l <= h) {
		   
		   mid = l + (h-l)/2;
		   
		   if(nums[mid] == target) {
			   
			   if(mid == n -1 || nums[mid+1] > nums[mid])
				   return mid;
			   
			   else
				   l = mid +1;
		   }
		   
		   else if(nums[mid] < target)
			   l = mid +1;
		   
		   else
			   h = mid -1;
	   }
	   
	   return -1;
   }
   

}


//Time Complexity : O(log n) as we performed binary search for finding first occurrence and then another binary search for last element
//Space Complexity : O(1) as it's taking constant space
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

import java.util.*;

public class firstLastPosition {

	 public static int[] searchRange(int[] nums, int target) {
	        if(nums.length == 0 || nums == null) return new int[] {-1, -1};  //{-1, -1} 2 values for //first and last occurence
	        if(target < nums[0] || target > nums[nums.length - 1]) return new int[] {-1, -1}; 
	        
	        int first = BinarySearchFirstOcc(nums , target);
	        if(first == -1) return new int[] {-1, -1};  // means if BinarySearchFirstOcc method returns -1 that means there is no first occurrence of an element. Means there is no such elelemnt in the given sorted array
	        int last = BinarySearchLastOcc(nums , target);
	        return new int[] {first, last};
	    } 
	        public static int BinarySearchFirstOcc(int[] nums, int target)
	        {
	                    
	        int low=0;
	        int high= nums.length -1;
	            
	            while(low <= high)
	            {
	                int mid= low+ ((high-low)/2);
	            
	                if(target == nums[mid]){  //1st case
	                    if(mid == 0 || nums[mid-1]< target)
	                        return mid;
	                    else{
	                        high=mid-1;  // as array is sorted and we have to find 1st occurence. If it's mid-1 is also same then we have to move left in order to find first occurence of target
	                    }
	                }
	                else if(target < nums[mid]){ //2nd case
	                    high=mid-1;
	                }
	                else{
	                    low=mid+1;
	                }
	            }
	            return -1;
	        }         
	    
	        public static int BinarySearchLastOcc(int[] nums, int target)
	        {
	                    
	        int low=0;
	        int high= nums.length -1;
	            
	            while(low <= high)
	            {
	                int mid= low+ ((high-low)/2);
	            
	                if(target == nums[mid]){  //1st case
	                    if(mid == nums.length-1 || nums[mid+1]> target)
	                        return mid;
	                    else{
	                        low=mid+1;  // as array is sorted and we have to find Last occurence. If it's mid+1 is also same then we have to move right in order to find Last occurence of target
	                    }
	                }
	                else if(target < nums[mid]){ //2nd case
	                    high=mid-1;
	                }
	                else{
	                    low=mid+1;
	                }
	            }
	            return -1;
	        }   

	    public static void main(String[] args) {
	    int[] nums = new int[] {5,7,7,8,8,8,8,8, 10};
	    int target = 8;
	    
	    int[] result= searchRange(nums, target);
	    
	    System.out.println("The first occurrence of target is at index\t"+result[0]);
	    System.out.println("The Last occurrence of target is at index\t"+result[1]);
	}
}

//Time Complexity : O(log n) as we performed binary search to find peak and for that we eliminated one part of an array 
//Space Complexity : O(1) as it's taking constant space
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

import java.util.*;

public class indexOfPeak {

	public static int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;   // as only 1 element. It will be peak
        int low=0;
        int high= nums.length - 1;
        while(low <= high)
        {
            int mid = low+ ((high-low)/2);  // to avoid integer overflow
            //check whether mid element is greater than it's neighbour elements? If Yes. Then mid is the peak. Return peak
            if((mid == 0 || nums[mid] > nums[mid-1])  &&  (mid == nums.length-1 || nums[mid]> nums[mid+1]) )
            {
                return mid; // it will return index of the peak element in the given array
            }
            else if(mid == nums.length-1 || nums[mid]<nums[mid+1]) //if mid is last element or mid is less than mid+1 then make low = mid+1 as we have to move towards greater element
            {
                low=mid+1;
            }
            else{
                high = mid-1;
            } 
        }
        return 9999999;
    } 
	public static void main(String[] args) {
		//int[] nums=new int[] {1,2,1,3,5,6,4};
		//int[] nums=new int[] {1,2};
		//int[] nums=new int[] {1};
		//int[] nums=new int[] {};
		int[] nums=new int[] {6,3,5,4,1};
		
		int result= findPeakElement(nums);
		
		if(result == 9999999)
		{
			System.out.println("No peak element found");
		}
		else if(result == -1)
		{
			System.out.println("No elements in an Array");
		}
		else if(result == 0) {
			System.out.println("Only one element in an array");
		}
		else {
			System.out.println("The index of element is : "+ result);
		}

	}

}

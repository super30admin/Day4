// Time complexity o(logn).
// Space complexity 0(1).
// runned on leetcode.

import java.io.*;

class GFG {
    public int findPeakElement(int[] nums) {
    int l=0;
	int h= nums.length-1;
	while(l<=h) {
    int mid = l+(h-l)/2;
		if ((mid == 0 || (nums[mid]>nums[mid-1]) )
            && (mid == nums.length-1 || (nums[mid] > nums[mid+1])))  {	 
			return mid;
		}
		else if(nums[mid+1]>nums[mid]) {
			
          l = mid +1;
		
			
		}else {
            h = mid -1;
           
				
		}
	}
    return -1;
}
public static void main (String[] args) {
	    GFG g1 = new GFG();
	    int nums[] ={1,2,3,1};
	    int result = g1.findPeakElement(nums);
		System.out.println(result);
	}
}
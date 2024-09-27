
public class Find_Peak_Element {
	
	//Approach: 1. I have used binary search, once mid element is found, am comparing it with the neighbors, if its greater than both neighbors, then we return it.
	//2. Else we will see if either any one of the neighbors is higher than the mid element, if so we will take that direction in search of finding a pivot.
	//3. Because the bigger element side, might keep growing or it might fall, either way we are sure to find a peak.  
	 public int findPeakElement(int[] nums) {
	        int left = 0, right = nums.length-1;
	        if(nums.length == 0)
	            return -1;
	        if(nums.length == 1)
	            return 0;
	        while(left <= right)
	        {
	            int mid = left + (right-left)/2;
	            if((mid == 0 || nums[mid-1] <= nums[mid]) && (mid == nums.length - 1 || nums[mid+1] <= nums[mid] ))
	                return mid;
	            else 
	            {
	                if(mid > 0 && nums[mid-1] >= nums[mid])
	                    right = mid-1;
	                else
	                    left = mid+1;
	            }    
	        }
	        return left;
	 }
}

//Time Complexity : O(log n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

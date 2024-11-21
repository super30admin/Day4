// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0)
        	return -1;
        int min=0;
        int max=nums.length-1;
        
        while(min<=max) {
        	int mid=min+(max-min)/2;
        	if(nums.length==1)
        		return min;
        		
            
			  if((mid==0 && nums[mid+1]>nums[mid])) {
				 return mid+1;
			 } else if ((mid == 0 || nums[mid - 1] <= nums[mid]) 
			            && (mid == max || nums[mid + 1] <= nums[mid])) 
		            return mid; 
        	
			 else if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])
        		return mid;
        	else if(nums[mid-1]>nums[mid]) {
        		max=mid-1;
        	}else if(nums[mid+1]>nums[mid]){
        		min=mid+1;
        	}
        }
        return -1;
        
    }
}

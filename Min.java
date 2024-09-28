//Time Complexity : O(logn)
//Space Complexity : O(1)
//Code run successfully on LeetCode.
public class Min {
	  public int findMin(int[] nums){
	        
	    	if(nums.length == 0)
	    		return -1;
	    	
	    	if(nums.length == 1)
	    		return nums[0];
	    	
	    	int n = nums.length;
	    	
	    	if(nums[0] < nums[n-1])
	    		return nums[0];
	    
	    	int l = 0;
	    	int h = n-1;
	    	int mid;
	    	
	    	while(l <= h) {
	    		
	    		mid = l + (h-l)/2;
	    		
	    		if(mid!= n-1 && nums[mid +1] < nums[mid])
	    			return nums[mid + 1];
	    		
	    		if(mid!= 0 && nums[mid-1] > nums[mid])
	    			return nums[mid];
	    		
	    		if(nums[l] < nums[mid])
	    			l = mid+1;
	    		
	    		else
	    			h = mid -1;
	    		
	    	}
	    	
	    	return -1;
	    	
	    }
}

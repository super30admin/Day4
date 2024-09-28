//Time Complexity : O(logn)
//Space Complexity : O(1)
//Code run successfully on LeetCode.

public class PeakElement {
	
public int findPeakElement(int[] nums) {
    	
    	if(nums.length == 0)
    		return -1;
    	
    	if(nums.length == 1)
    		return 0;
    	
    	int l =0;
    	int n = nums.length;
    	int h = n-1;
    	int mid;
    	
    	while(l <= h) {
    		
    		mid = l + (h-l)/2;
    		
    		if((mid ==0 || nums[mid] > nums[mid -1]) && (mid == n-1|| nums[mid] > nums[mid+1]))
    			return mid;
    		
    		else if(mid== n-1 ||nums[mid +1] > nums[mid])
    			l = mid +1;
    		else 
    			h = mid -1;
    	}
        return -1;
    }

}

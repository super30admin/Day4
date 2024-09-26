//Find Minimum in Rotated Sorted Array

// Time Complexity :  O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : yes

public class Binarysearch3{
	
    public int findMin(int[] nums) {
    	
    	if(nums == null || nums.length==0) {
    		return -1;
    	}

        /*
        *checking element at l is less than element at h --> return element at loe
        *checking mid element is less than element at mid-1 and greater than element at mid+1
        *checking whether the left half is sorted and adjusting the left and right pointers
        */
        
    	int l =0, h = nums.length-1;    	
    	int mid = 0;
    	while(l<=h) {
            mid = l +(h-l)/2;
    		if(nums[l]<nums[h]) {
    			return nums[l];
    		}
    		if((mid==l || nums[mid]<nums[mid-1]) && (mid==h || nums[mid]<nums[mid+1])) {
    			return nums[mid];
    		}
    		else if(nums[l]<=nums[mid]) {
    			l = mid+1;
    		}else {
    			h = mid-1;
    		}
    	}
    	return -1;
    }
  
	public static void main(String[] args) {
		Binarysearch3 bs = new Binarysearch3();
		int[] nums = {3,4,5,1,2};
		System.out.println(bs.findMin(nums));
		
	}
}
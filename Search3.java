//Find Peak Element

// Time Complexity :  O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : yes


public class BinarySearch4{
	
    public int findPeakElement(int[] nums) {
    	
    	int l =0, h = nums.length-1;
    	int mid=0;
    	while(l<=h) {
    		mid = l +(h-l)/2; 
    		if(( mid == l || nums[mid]>nums[mid-1]) && (mid==h || nums[mid]>nums[mid+1])){
    			return mid;
    		}
    		else if(nums[mid]>nums[mid+1]) {
    			//search left for the peaks
    		
                h = mid-1;
    		}
    		else {
                //search right for the peaks
                                
    			l = mid+1; 
    		}
    	}
    	return -1;
        
    }
	
	public static void main(String[] args) {
		BinarySearch4 bs = new BinarySearch4();
		int[] nums = {1,2,3,1};
		System.out.println(bs.findPeakElement(nums));
		
	}
}


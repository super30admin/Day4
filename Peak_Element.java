//Time Complexity : O(logn)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : Found difficulty in finding a the best solution at first attempt.

class Peak_Element {

    public int findPeakElement(int[] nums) {

    	int left = 0;
    	int right = nums.length-1;
    	
    	if(nums == null || nums.length == 0)
    		return -1;
    	
    	if(nums.length == 1)
    		return 0;
    	else if(nums.length == 2)
    		return nums[1] > nums[0] ? 1 : 0;
    		
    		while(left < right)
    		{
                int mid = left + (right - left) / 2;
                if(nums[mid] < nums[mid+1])
                	left = mid+1;
                else
                    right = mid;
            }
            return left;
    }
    
    public static void main(String[] args) { 
		int[] nums = {1,2,3};
		int[] nums2 = {1,2,5,6,4,1,3};
		
		Peak_Element srch = new Peak_Element();
		
		System.out.println(srch.findPeakElement(nums));
		
		System.out.println(srch.findPeakElement(nums2));

	}
    
}
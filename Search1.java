//Find Minimum in Rotated Sorted Array

// Time Complexity :  O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : yes


public class Search1{
	
	public int bsfirst(int[] nums, int target) {     
        /*
        *method to search the first occurence of the target
        */
		
		int l = 0, h = nums.length-1;
		int mid=0;
		while(l<=h) {
			mid = l+(h-l)/2;
			
			if(target == nums[mid]) {
				if(mid == l|| nums[mid]>nums[mid-1]) {                      //checking edge cases
					return mid;
				}else {
					h = mid -1;
				}
			}
			else if(target<nums[mid]) {
				h = mid-1;
			}
			else {
				l = mid+1;
			}			
		}
		return -1;		
	}
	
    public int bslast(int[] nums, int target) {
          /*
        *method to search the second occurence of the target
        */
    	
    	int l = 0, h = nums.length-1;
    	int mid=0;
		while(l<=h) {
			mid = l+(h-l)/2;
			
			if(target == nums[mid]) {
				if(mid == h || nums[mid]<nums[mid+1]) {
					return mid;
				}else {
					l = mid +1;
				}
			}
			else if(target<nums[mid]) {
				h = mid-1;
			}
			else {
				l = mid+1;
			}			
		}
		return -1;	
	}
	
	
    public int[] searchRange(int[] nums, int target) {
    	if(nums==null || nums.length==0) {
    		return new int[] {-1,-1};
    	}
    	
    	int first = bsfirst(nums,target);
    	int last = bslast(nums,target);
        return new int[] {first,last};
    }
  
	public static void main(String[] args) {
		BinarySearch2 bs = new BinarySearch2();
		int[] nums = {5,7,7,8,8,10};
		int[] res = bs.searchRange(nums, 8);

        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
		
	}
}


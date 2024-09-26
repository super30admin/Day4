// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class Problem_1 {
	
	   public int[] searchRange(int[] nums, int target) 
	   {
	        int[] result = {-1, -1};
	        result[0] = searchLeft(nums, target);
	        result[1] = searchRight( nums,  target);
	        return result;
	  	}
	    public int searchLeft(int[] nums, int target){
	        int low = 0;
	        int high = nums.length - 1;
	        
	        while(low <= high){
	            int mid = low + (high - low)/2;
	            if(mid != 0 && nums[mid] == target && nums[mid-1] < target ){
	                return mid;
	            }
	            if(mid == 0 && nums[mid] == target){
	                return mid;
	            }
	            if(nums[mid] >= target){
	                high = mid - 1;
	            }else{
	                low = mid + 1;
	            }
	        }
	        return -1;
	    }
	    
	    public int searchRight(int[] nums, int target){
	        int low = 0;
	        int high = nums.length - 1;
	        
	        while(low <= high){
	            int mid = low + (high - low)/2;
	            if(mid != nums.length-1 && nums[mid] == target && nums[mid+1] > target ){
	                return mid;
	            }
	            if(mid == nums.length-1 && nums[mid] == target){
	                return mid;
	            }
	            if(nums[mid] <= target){
	                low = mid + 1;
	            }else{
	                high = mid - 1;
	            }
	        }
	        return -1;
	    }

}

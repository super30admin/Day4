// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {
	        if(nums==null || nums.length==0)
	        	return -1;
	        else {
	        	int min=0;
	        	int max=nums.length-1;
	        	
	        	while(min<=max) {
	        		int mid=min+(max-min)/2;
	        		
	        		 if(mid==0 && max==mid+1 && nums[mid]>nums[mid+1])
	        			return nums[mid+1];
	        		else if(nums.length-1==0 || mid==max || (mid==min&&min==0) ||  ((nums[mid]<nums[mid-1]) && (nums[mid]<nums[mid+1]))) {
	        			return nums[mid];
	        		}else if(nums[mid]>nums[nums.length-1]) {
	        			min=mid+1;
	        		}else {
	        			max=mid-1;
	        		}
	        	}
	        }
	        return -1;
	    }
}

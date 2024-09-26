package com.hashmap;

public class FirstAndLastPositionOfElementInSortedArray {

	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10,8};
        int target = 8;
        FirstAndLastPositionOfElementInSortedArray obj = new FirstAndLastPositionOfElementInSortedArray();
        System.out.println("first and last position of target; start index = "+obj.searchRange(nums,target)[0]+" end index="+obj.searchRange(nums,target)[1]);
    

	}
	
	 public int[] searchRange(int[] nums, int target) {
	        return new int[]{findLeftMostOcurrence(nums,target),findRightMostOcurrence(nums,target)};
	    }
	    
	    public int findLeftMostOcurrence(int[] nums, int target)
	    {
	        int index = -1;
	        int left = 0;
	        int right = nums.length - 1;
	        while(left<=right)
	        {   int mid = left + (right - left)/2;
	            if(nums[mid]<target) left = mid + 1; //ocurence of target must be on the right side of the mid
	            else right = mid - 1; 
	            
	            if(nums[mid]==target) index = mid; //we are storing the location of the latest ocurrence of target
	        }
	        
	        return index;
	    }
	    
	    public int findRightMostOcurrence(int[] nums, int target)
	    {
	        int index = -1;
	        int left = 0;
	        int right = nums.length - 1;
	        
	        while(left<=right)
	        {   int mid = left + (right - left)/2;
	            if(nums[mid]>target) right = mid - 1; //ocurence of target must be on the left side of the mid
	            else left = mid + 1;
	            
	            if(nums[mid]==target) index = mid; //we are storing the location of the latest ocurrence of target
	        }
	        
	        return index;
	        
	    }

	    
}

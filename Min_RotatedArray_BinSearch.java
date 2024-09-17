package Minimum_RotatedArray;

public class Min_RotatedArray_BinSearch {
	
		public static int findMin(int nums[])
		{
		     int low = 0;
		     int high = nums.length-1;
		     while(low<=high)
		     {
		    	 if(nums[low] < nums[high])
		    	 {
		    		 return nums[low]; //This is the case when array is sorted and not rotated
		    	 }
		    	 
		    	 int mid = low + (high-low)/2;
		    	 if((mid==0 ||  nums[mid]<nums[mid-1]) && (mid==nums.length-1 || nums[mid]<nums[mid+1]))
		    	 {
		    		 return nums[mid];
		    	 }
		    	 
		    	 else if(nums[mid]<nums[high])
		    	 {
		    		 high = mid-1;
		    	 }
		    	 
		    	 else
		    	 {
		    		 low = mid+1;
		    	 }
		     }
		     
		     
		     return -1;
		}
	

	public static void main(String[] args) {
		
		//int nums[] = {3,4,5,6,7,0,1,2};
		//int nums[] = {3,4};
		//int nums[] = {4,3};
		int nums[] = {1};
		
		int obj = findMin(nums);
		System.out.println("The minimum element in the given array is " + obj);
		
		// TODO Auto-generated method stub

	}

}

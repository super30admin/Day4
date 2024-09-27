
//Time Complexity : O(log n) as we are performing binary search
//Space Complexity : O(n) where n is size of Array. 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : Yes, index is not printing correctly

//Your code here along with comments explaining your approach

/*Step 1: Create rotated array where either left of mid or right of mid will be sorted and opposite will be unsorted
 * Step 2: If we find minimum at the middle, print middle element
 * Step 3: If we don't find minimum at the middle, we will compare the low from mid. If low is less than mid means left part is orted else right part is sorted. 
 * Step 4: We will move towards unsorted part and perform binary search on unsorted part to find minimum element and at last return the element
 */

public class minRotatedArray {

	    public static int findMin(int[] nums) {
	        if(nums.length == 0 || nums == null) return -1;
	        
	        if(nums.length == 1) return nums[0];
	        
	        int low=0; 
	        int high= nums.length-1;
	        
	        while(low <= high)
	        {
	            if(nums[low]<nums[high])
	            {
	                return nums[low]; // means array is sorted and element at 0th index is minimum
	            }
	            int mid=low + ((high-low)/2);
	            
	            if((mid == 0 || nums[mid]<nums[mid-1]) && (mid == nums.length-1 || nums[mid]<nums[mid +1]))
	            {
	                return nums[mid];
	            }
	            else if(nums[low]<=nums[mid])
	            {
	                low = mid+1;
	            }
	            else{
	                high = mid -1;
	            }
	        }
	        return 99999;
	    }	                  
	                    
	public static void main(String[] args) {
		        int[] nums=new int[] {4,5,6,7,0,1,2};
				//int[] nums=new int[] {1,2};
				//int[] nums=new int[] {1};
				//int[] nums=new int[] {};
				
				int result= findMin(nums);
				
				if(result == 99999)
				{
					System.out.println("No minimum element found");
				}
				else if(result == -1)
				{
					System.out.println("No elements in an Array");
				}
				else {
					System.out.println("The minimum element in rotated Array is : "+ result);
				}

			}

	}


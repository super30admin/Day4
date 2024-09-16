/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    
    public int findLowestElement(int[] nums){
        
        int low=0;
        int high=nums.length-1;
        
        while(low <= high){
            
            if(nums[low] < nums[high]){
                return nums[low];
            }
            
            int mid = low + (high - low)/2;
            
            if( (mid == 0 || nums[mid] < nums[mid -1]) && 
                ( mid == nums.length - 1 || nums[mid] < nums[mid + 1]))
                return nums[mid];
            if(nums[high] < nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return -1;
        
        
    }
	public static void main (String[] args) {
		System.out.println("GfG!");
		
		GFG gfg = new GFG();
		int nums[] = {1, 2, 3, 4, 0};
		System.out.println(gfg.findLowestElement(nums));
	}
}
// Time Complexity : O(logn) n :bumber of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class FindMin {
	
	//Find the min in the rotated array
    public int findMin(int[] nums) {
        if(nums==null || nums.length<1){
            return -1;
        }
        int low =0; int high = nums.length-1;
        //apply binary search method
        while(high>low){
            
            int mid = low + (high-low)/2;
            
            
            if(mid>low &&  nums[mid]<nums[mid-1]){
                
                return nums[mid];
            }
            if(high>mid && nums[mid]>nums[mid+1]){
                
                return nums[mid+1];
            }
            if(nums[mid]<nums[high]){
                high = mid;
            }else if(nums[mid]> nums[low]){
                low = mid+1;
            }
        }
        return nums[0];
        
    }
}
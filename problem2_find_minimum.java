// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


public class Solution {
    

    public int findMin(int[] nums) {
        
        if(nums.length==1) return nums[0];
        if(nums[0]<=nums[nums.length-1]) return nums[0];
        
        int low = 0;
        int high = nums.length-1;       
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(nums[low]<=nums[high]) return nums[low];
            
            //check middle element is the lowest
            if((mid== 0 || nums[mid]<nums[mid-1] ) && (mid==nums.length-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }           
            
            //check if left side is sorted            
            else if(nums[mid] >= nums[low]){
                low = mid+1;
            }else {
               //right sid is sorted                
                high = mid-1;                
            }       
        }
        
        return 1034;
        
    }

}

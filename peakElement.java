//Time Complexity : O(logn)
//Space Complexity : O(1). No extra space used
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int findPeakElement(int[] nums) {
        
          if(nums.length == 0 || nums == null){return -1;}
        
        if(nums.length == 1){
            
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
         while(left <= right){
              int  mid = left + (right - left)/2;
            
            if(left == right){
                
                return left;
            }
            
           else if( mid != nums.length-1 && nums[mid] > nums[mid+1]){
               
               right = mid;
               
               
           }
            
            else if( mid != nums.length-1 && nums[mid] < nums[mid+1]){
                
                left = mid + 1;
            }
            
            
        }
        return -1;
        
    }
}
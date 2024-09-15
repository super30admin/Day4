//Time Complexity : O(logn)
//Space Complexity : O(1). No extra space used
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    
    private int binarySearchLeft(int[] nums, int left, int right, int target){
        
    
        
        while(left <= right){
              int  mid = left + (right - left)/2;
            
            if(nums[mid] == target){
                
            //    System.out.println("hitting");
                
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    
                    return mid;
                }
                
                else right = mid - 1;
                
                //return ;
            }
            
           else if(nums[mid] > target){
               
               right = mid - 1;
               
               
           }
            
            else {
                
                left = mid + 1;
            }
            
            
        }
        return -1;
    }
    
     private int binarySearchRight(int[] nums, int left, int right, int target){
        
      
        
        while(left <= right){
              int  mid = left + (right - left)/2;
            
            if(nums[mid] == target){
                
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]){
                    
                    return mid;
                }
                
                else left = mid + 1;
                
                //return ;
            }
            
           else if(nums[mid] > target){
               
               right = mid - 1;
               
               
           }
            
            else {
                
                left = mid + 1;
            }
            
            
        }
         
         return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length == 0 || nums == null) return new int[]{-1,-1};
        if(target < nums[0] || target > nums[nums.length-1]) return new int[]{-1,-1};
        int[] result = new int[2];
        
        result[0] = binarySearchLeft(nums, 0 , nums.length - 1, target);
        result[1] = binarySearchRight(nums, 0, nums.length - 1,  target);
            
            return result;
        
        
    }
}
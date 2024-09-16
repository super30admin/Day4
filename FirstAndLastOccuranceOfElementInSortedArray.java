class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if( nums == null || nums.length == 0 ) return new int[] {-1,-1};
        
        int first = binarySearchLeft(nums,target); //first occurance search on left side of mid
        int last = binarySearchRight(nums,target);//last occurance search on right side of mid
        
        
        return new int[] {first,last};
    }   
    
    private int binarySearchLeft(int[] nums,int target){
        int low = 0; int high = nums.length - 1;
        
        while(low <= high){
          
          int mid = low + (high - low)/2;
            
          if(nums[mid] == target ){
              
              if (mid == 0 || nums[mid] > nums[mid - 1]){
                  return mid;
              } else {
                  high = mid - 1;
              }
          }
          else if(nums[mid] < target){
              low = mid + 1;
              
          }  
          else{
              high = mid - 1;
          }  
        
        }
        return -1;
    }
    
    
        
    private int binarySearchRight(int[] nums,int target){
        
        int low = 0; int high = nums.length - 1;
        
        while(low <= high){
         int mid = low + (high - low)/2;
            
          if(nums[mid] == target ){
              
              if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]){
                  return mid;
              } else {
                  low = mid + 1;
              }
          }
          else if(nums[mid] < target){
              low = mid + 1;
              
          }  
          else{
              high = mid - 1;
          }  
        
        }
        return -1;
    }
}
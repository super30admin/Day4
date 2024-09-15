class Solution3 {
    
    // Time complexity  : O(logn) 
    // failing on edge cases for e.g [2,1]
  public int findPeakElement(int[] nums) {
   
  int l = 0;
      int r = nums.length-1;
     
      while(l <= r){
           int mid = l +(r-l)/2;
          if(mid>0 && mid < nums.length -1){
              
              if(nums[mid] > nums[mid-1] && nums[mid+1] < nums[mid]){
                  return mid;
              }
              else if(nums[mid -1] > nums[mid]){
                  r = mid-1;
              }else{
                  l = mid+1;
              }
          }else if(mid ==0) {
             return Math.max(nums[0], nums[1]);
          }
          else if(mid == nums.length-1){
              return Math.max(nums[nums.length-1], nums[nums.length-2]);
          }
      }
      
      return l;
 
  }
}
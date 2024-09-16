// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int findMin(int[] nums) {
      // can also do l < h then go left, else go right
      // and then do binary search
      
      int low = 0;
      int high = nums.length - 1;
      
      if(nums[high] > nums[0]){
        return nums[0]; //sorted
      }
      
      
      
      int min = Integer.MAX_VALUE;
      while(low <= high){
        int mid = low+(high-low)/2;
        
        if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid] < nums[mid+1] )){
          // (1 || 2) && (3 || 4) -> 1&4 can happen together, 2&3 can happen together
          return nums[mid];
        }
        
        if(nums[high] < nums[mid]){
          low = mid +1;
        }else{
          high = mid -1;
        }

      }
      return -1;
    }
  }

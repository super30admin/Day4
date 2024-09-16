
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class FindFirstLastPositionElementSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
       int startIndex = startIndex(nums, target);
        
        if(startIndex == -1){
            return new int[]{-1,-1};
        }
        
        return new int[]{startIndex, endIndex(nums,target)};
    }
    
    // O(logn) to find start and end indexes
    public int startIndex(int[] nums, int target){
        int low =0;
         int high = nums.length-1;
        
        while(high >= low){
            
            int mid = low + (high - low) /2;
            // keep going until we dont found differnet element or end or array
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]!=target){
                     return mid;
                }  else {
                    high = mid -1;
                }
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid +1;
            }
        }
        
        return -1;
    }
    
     public int endIndex(int[] nums, int target){
        int low =0;
         int high = nums.length-1;
         
        while(high >= low){
            
            int mid = low + (high - low) /2;
         // keep going until we dont found differnet element or end or array
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]!=target){
                  return mid;
                }  else {
                    low = mid +1;
                }
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid +1;
            }
        }
        
        return -1;
    }
}
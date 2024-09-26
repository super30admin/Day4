//Time Complexity : O(logm) + O(logn)

class Solution {
    
    int lowForLast;
    int low;
    int high;
    private int binarySearchFirst(int[] nums, int target) {
        low = 0;
        high = nums.length-1;
        
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                
                if(mid == 0 || nums[mid] > nums[mid-1]) {
                     return nums[mid];
                }
                   
                else {
                    high = mid - 1;
                }
                    
                
                
            } else if(nums[mid] > target) {
                high = mid - 1;
            }
                
              else {
                 low = mid + 1; 
              }
                  
        }
        
        return -1;
        
    }
    
     private int binarySearchLast(int[] nums, int target) {
         
         while (low <= high) {
             low = lowForLast;
             high = nums.length - 1;
             int mid = low + (high - low)/2;
             if(nums[mid] == target) {
                 if(mid == nums.length - 1 || nums[mid] < nums[mid + 1])
                     return nums[mid];
                 else 
                     low = mid + 1; 
                 
             } else if(nums[mid] > target)
                 high = mid - 1;
               else 
                 low = mid + 1;
         }
         
         return -1; 
     }
    
    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) return new int[] {-1, -1};
        if (nums[0] > target ||  nums[nums.length-1] < target) return new int[] {-1,-1};
        int first = binarySearchFirst(nums, target);
        if(first == -1) return new int[] {-1,-1};
        lowForLast = first;
        int last = binarySearchLast(nums, target);
        return new int[] {first,last};
        
    }
}


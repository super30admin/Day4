// Time Complexity : O(log N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums ==null|| nums.length ==0) return -1;
        int low = 0; 
        int high = nums.length-1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if((mid == 0 || nums[mid] > nums[mid-1]) && 
                (mid == nums.length-1 || nums[mid] > nums[mid+1])){
                    return mid;
            }
        else if(mid != 0 &&nums[mid] < nums[mid-1]){
               
            high = mid-1;
        }
        else{
            
            low = mid+1;
        }
            
        }
                return 99;
    }
}
// Time Complexity : O(log N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :No,Runtime Error


// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
             int mid = low +(high - low)/2;
                // if the value at oth index is greater than the last index value //the we can have two conditins the array is rotated n times or it may not be a //sorted array! 
                if(nums[low] < nums[high]) return nums[low];
               
                if((nums[mid] == 0 || nums[mid] < nums[mid-1]) 
                   && (nums[mid] == nums.length-1 || nums[mid] < nums[mid+1])){
                    return mid;
                }
            else if(nums[mid] > nums[mid -1]){
                //moving towrads right
                low = mid+1;
            }
            else{
                high = mid+1; 
            }
       
                        
        }
         return 999;
        
    }
}

// Time Complexity : O(log N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :No,Runtime Error


// Your code here along with comments explaining your approach
class Solution {
    public int binearySearchFirst(int [] nums, int target){
        int low =0; int high = nums.length-1;
        while(low <= high){
       int mid = low + (high -low)/2;
        if(nums[mid] == target){
            if(mid == 0 || nums[mid-1] != nums[mid]){
            return mid;
        }else{
            high = mid-1;
        }
    }
        else if(nums[mid] > target){
            high = mid-1;
        }
        else{
            low = mid+1;
        }
           
        }
         return 99;
    }
    
        
      public int binearySearchLast(int [] nums, int target){
        int low = 0; int high = nums.length-1;
        while(low<=high){
            int mid = low + (high -low)/2;
        if(nums[mid] == target){
             if(mid == nums.length-1 || nums[mid+1] != nums[mid]){
                   return mid;
             }
            else{
                low = mid+1;;//keep moving right
            }  
            
        }
        else if(nums[mid] > target){
             high = mid-1;
        }
        else{
           low = mid-1;
        }
           
        
    }
           return 999;
        
 }
        
    public int[] searchRange(int[] nums, int target) {
        if(nums == null|| nums.length == 0) return new int[]{-1,-1};
if(nums[0]>target || nums[nums.length-1] < target) return new int[] {-1,-1};
      
        int first = binearySearchFirst(nums,target);
        if(first == -1) return new int[]{-1,-1};
        int last = binearySearchLast(nums,target);
        
        return new int[] {first,last};
    }
}
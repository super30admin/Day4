// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    
    public int[] searchRange(int[] nums, int target) {       
               
       if(nums==null || nums.length==0) return new int[]{-1,-1};
        
        if(target<nums[0] || target >nums[nums.length-1]) return new int[]{-1,-1};
        
        int indexLeft= binarySearchLeft(nums,target);
        
        if(indexLeft == -1){
            return new int[]{-1,-1};
        }
        
        int indexRight= binarySearchRight(nums,target);
        
        return new int[]{indexLeft,indexRight};        
    }
    
    int binarySearchLeft(int[] nums,int target){
        int low = 0;
        int high= nums.length-1;
        
        while(low<=high){
        int mid =low+(high-low)/2;
        if(target==nums[mid]){
            if(mid==0 || nums[mid-1]!=target){
                return mid;
            }else{
                high = mid -1;
            }
        }else if(target>nums[mid]){
            low = mid+1;
        }else{
            high =mid-1;
        }   
    }   
    
        return -1;
    }
    
     int binarySearchRight(int[] nums,int target){
        int low =0;
        int high = nums.length-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(nums[mid]==target){
                if(mid == nums.length-1 || nums[mid+1]!=target){
                    return mid;
                }else{
                    low = mid+1;
                }
            }else if(target<nums[mid]){
                high =mid-1;
            }else{
                low = mid+1;
            }
        }
         return -1;
    }
}
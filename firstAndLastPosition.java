/*Applying binary search twice 1 to find first position 2 to find last position of target.
*/
class Solution {
    public int searchFirst(int[] nums,int target, int left, int right){
        if(left>right){
            return -1;
        }
       int mid = left+(right-left)/2;               //calculating mid
        if(nums[mid]==target){                      // chceking id mid is equal to target
            if(mid!=0 && nums[mid-1]==target){      // if yes checking mid should not be the first element of array and if equal to prev element of mid
               return searchFirst(nums,target,left,mid-1);  // using recursion by changing right to mid-1
            }else{
                return mid;                         //if its first element and equal to target then returning mid as its the first position
            }
        }else if(nums[mid]<target){                 //if mid is less than target changing left to mid+1
             return searchFirst(nums,target,mid+1,right);
        }else{
             return searchFirst(nums,target,left,mid-1);        //if greater changing right to mid-1
        }
    }
    
    public int searchLast(int[] nums, int target, int left , int right){
        if(left>right){
            return -1;
        }
        int mid = left+(right-left)/2;
        if(nums[mid]==target){
            if(mid!=nums.length-1 && nums[mid+1]== target){
                return searchLast(nums,target,mid+1,right);
            }else{
                return mid;
            }
        }else if(nums[mid]<target){
            return searchLast(nums,target,mid+1,right);
        }else{
            return searchLast(nums,target,left,mid-1);
        }  
    }
    
    
    
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        if(nums.length == 0 || nums == null){
            return new int[] {-1,-1};
        }
        
        int first = searchFirst(nums, target,left,right);
        int last = searchLast(nums,target,left,right);
        return new int[]{first,last};
        
    }
}
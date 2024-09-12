// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

class Solution {
    public int[] searchRange(int[] nums, int target) {
       if(nums == null || nums.length == 0){
           return new int[]{-1, -1};
       } 
       //instead of using two binary searches, we can add boolean at  end to differentiate them
       int first = binarySearch(nums, target, false);
        int last = binarySearch(nums, target, true);
        
        return new int[]{first, last};
    }
    
    private int binarySearch(int[] nums, int target, boolean last){
        int low = 0, high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            //once mid is the target then we search for the first/last occurence
            if(nums[mid] == target){
                
                //first occurence
                if(!last){
                    //reached end of array or reached first target value
                    if(mid == 0 || nums[mid] > nums[mid - 1]){
                        return mid;
                    }
                    else{
                        high = mid -1;
                    }
                }
                //last occurence
                else{
                    //reached end of array or reached final target value
                    if(mid == 0 || nums[mid] < nums[mid + 1])
                        return mid;
                    else
                        low = mid + 1;
                }
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
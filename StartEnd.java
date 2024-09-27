// Time Complexity : O(log n) n: numbeo of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length<1){
            return new int[]{-1,-1};
        }
        if(nums.length==1 && nums[0] == target){
            return new int[]{0,0};
        }
        int first = getFirstPosition(nums, 0, nums.length-1, target);
        int last = getLastPosition(nums, 0, nums.length-1, target);
        return new int[]{first, last};
        
    }
    
    private int getFirstPosition(int[] nums, int low, int high, int target){
        while(high>=low){
            
            int mid = low + (high-low)/2;
            if(mid>0 && nums[mid]==target){
                
                if(nums[mid-1]!=nums[mid]){
                    return mid;
                
            }else{
                   high = mid-1; 
                }
                
            } 
            else if(nums[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    private int getLastPosition(int[] nums, int low, int high, int target){
        while(high>=low){
            int mid = low + (high-low)/2;
            if(nums.length-1>mid && nums[mid]==target){
                
                if(nums[mid+1]!=nums[mid]){
                    return mid;
                }else{
                    low = mid+1;
                }
                
            }
            else if(nums[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}
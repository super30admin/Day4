// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = searchFirst(nums,target);
        result[1] = searchLast(nums,target);
        return result;
    }
    
    public int searchFirst(int[] nums, int target){
        int first=-1;
        int low=0, high=nums.length-1;
    
        while(low<=high){
            int mid= low+(high-low)/2;
            
            if (nums[mid] < target){
                low = mid +1;
            } else if (nums[mid] > target){
                high = mid - 1;
            } else { // nums[mid] == target
                //nothing after mid means first occurance of target value
                //reduce search to nums[0:mid-1]
                first = mid;
                high = mid - 1; 
            }
        }
        return first;
    }
    
    public int searchLast(int[] nums, int target){
        int last = -1;
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            
            int mid = low + (high-low)/2;
            
            if (nums[mid] < target){
                low = mid +1;
            } else if (nums[mid] > target){
                high = mid - 1;
            } else { // nums[mid] == target
                //last occurance of the target
                //reduce search array to nums[mid+1:high]
                last = mid;
                low = mid + 1;
            }
        }
        return last;
    }
    
}
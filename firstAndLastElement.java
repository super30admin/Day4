// Time Complexity O(logn)
// Space complexity O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = getStart(nums, target);
        int end = getEnd(nums, target, start);
        
        return new int[]{start, end};
    }
    
    private int getStart(int [] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid-1] != target) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }else if(target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
                
            }
        }
        
        return - 1;
    }
    
    private int getEnd(int [] nums, int target, int start) {
        if(start == -1) return -1; 
        
        int end = nums.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid+1] != target) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }else if(target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return - 1;
    }
}

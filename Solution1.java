/*
    Time Complexity: O(logn)
    Space Complexity: O(1)
    
    Accepted LeetCode URL: https://leetcode.com/submissions/detail/633769894/
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = firstIndex(nums, target);
        arr[1] = lastIndex(nums, target);
        
        return arr;
    }
    
    public int firstIndex(int[] nums, int target){
        int rv = -1;
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo <= hi){
            int mid = lo +(hi-lo) / 2;
            
            if(target == nums[mid]){
                rv = mid;
                hi = mid - 1;
            }else if(target < nums[mid]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        return rv;
    }
    
    public int lastIndex(int[] nums, int target){
        int rv = -1;
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo <= hi){
            int mid = lo +(hi-lo) / 2;
            
            if(target == nums[mid]){
                rv = mid;
                lo = mid + 1;
            }else if(target < nums[mid]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return rv;
    }
}

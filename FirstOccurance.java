// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        
        int[] res = new int[2];
        
        // First occurance
        int start = 0;
        int end = nums.length -1;
        
        while(start <= end){
            int mid = (start + end)/2;
            if(target == nums[mid]){
                first = mid;
                end = mid -1;
            }
            else if(target < nums[mid])
                end = mid -1;
            else
                start = mid +1;
        }
        res[0] = first;
        
        //Last occurance
        start = 0;
        end = nums.length -1;
        
        while(start <= end){
            int mid = (start + end)/2;
            if(target == nums[mid]){
                last = mid;
                start = mid +1;
            }
            else if(target < nums[mid])
                end = mid -1;
            else
                start = mid +1;
        }
        res[1] = last;
        
        return res;
    }
}
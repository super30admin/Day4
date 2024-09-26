// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, 0 ms
// Any problem you faced while coding this : No, I tried initially without modularity, and It didn't work


// Your code here along with comments explaining your approach


class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int start = 0;
        
        int end = nums.length-1;
        
        int ans1 = findFirst(nums, start, end, target);
        
        int ans2 = findLast(nums, start, end, target);
        
        return new int[]{ans1, ans2};
        
    }
    
    public int findFirst(int[] nums, int start, int end, int target){

        // Finding the First occurence in the first half of the array until the mid
        
        int ans = -1;
        
        while(start <= end){
            
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target){
                ans = mid;
                end = mid - 1;
            }
            
            else if(nums[mid] < target){
                start = mid + 1;
            }
            
            else{
                end = mid-1;
            }
            
        }
        
        return ans;
        
    }
    
    public int findLast(int[] nums, int start, int end, int target){

        // Finding the Second occurence in the second half of the array until the mid
        
        int ans = -1;
        
        while(start <= end){
            
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target){
                ans = mid;
                start = mid + 1;
            }
            
            else if(nums[mid] < target){
                start = mid + 1;
            }
            
            else{
                end = mid -1;
            }
            
            
        }
        
        return ans;

    }
    
}
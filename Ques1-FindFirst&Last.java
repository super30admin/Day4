// Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
// Time Complexity : O(Log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach
// 2 Binary Searches.
// 1st Binary Search for finding the left index of the target.
//     When the target is less than or equal to the mid go left.
// 2nd Binary Search for finding the right index of the target.
//      When the target is greater than or equal to the mid go right.
class Solution {
    public int findLeft(int[] nums, int target){
        int low = 0;
        int len = nums.length;
        int high = len-1;
        int ans = -1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(nums[mid]<target){
                low = mid+1;
            }
            else { // target is less than or equal to mid
                if(nums[mid]==target){
                    ans = mid;
                }
                high = mid-1;
            }
        }
        return ans;
    }
    
    public int findRight(int[] nums, int target){
        int low = 0;
        int len = nums.length;
        int high = len-1;
        int ans = -1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(nums[mid]<=target){
                if(nums[mid]==target){
                    ans = mid;
                }
                low = mid+1;
            }
            else { //target is less than mid
                high = mid-1;
            }
        }
        return ans;
    }
    
    
    
    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums,target);
        int right = findRight(nums,target);
        
        int[] ans = new int[2];
        ans[0] = left;
        ans[1] = right;
        
        return ans;
    }
}
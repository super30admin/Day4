// Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
// Time Complexity : O(Log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
// if(nums[mid]<=nums[len-1]){ // Couldn't think about the <= case without the test case failing for only [1]

// Your code here along with comments explaining your approach
// Binary Search for the index mid comparing it with the last index in the rotated array
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int len = nums.length;
        int high = len-1;
        int ans = -1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(nums[mid]<=nums[len-1]){ // Couldn't think about the <= case without the test case failing for only [1]
                high = mid-1;
                ans = nums[mid];
            }
            else{
                low = mid+1; 
            }
        }
        return ans;
        
        
    }
}

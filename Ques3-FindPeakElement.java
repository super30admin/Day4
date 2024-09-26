// Problem 3: (https://leetcode.com/problems/find-peak-element/)
// Time Complexity : O(Log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Binary search to find the direction where to go next.
// Depending on the comparison with the adjacent number to the mid
// i.e. mid compared with mid+1 and mid-1

class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(mid!=len-1 && nums[mid] < nums[mid+1]){
                low = mid+1;
            }
            else if(mid!=0 && nums[mid] < nums[mid-1]){
                high = mid-1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}

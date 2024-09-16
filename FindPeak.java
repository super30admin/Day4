// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/*
    We compare middle element with the next element. If it is smaller, then we search on the right side.
    Otherwise, we search on the left side to find the peak element.

*/
class Solution {
    public int findPeakElement(int[] nums) {
        int low =0, high = nums.length-1;
        while(low < high){
            int mid=low +(high-low)/2;
            if(nums[mid]<=nums[mid+1])
                low=mid+1;
            else
                high=mid;
        
        }
        return low;
        
    }
}
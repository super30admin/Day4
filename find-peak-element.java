// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//use binary search. check neighbours of mid element to find if its peak. take care of edge cases. if l>=r then l is peak.


class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if((mid == 0 && nums[mid] > nums[mid+1]) 
               || (mid == nums.length && nums[mid] > nums[mid-1]) 
               || (mid > 0 && mid < nums.length-1 && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])) return mid;
            if(mid > 0 && nums[mid] < nums[mid-1]){
                r = mid-1;
            } else {
                l = mid +1;
            }
        }
        return l;
    }
}
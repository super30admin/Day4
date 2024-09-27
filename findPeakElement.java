// Time Complexity: Performing binary Search O(log(n))
// Space Complexity: only constant space utilized O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : tried to handle mid+1 and mid-1 comparision caused array index out of bound, also checked case for low==high for while loop causing TLE

// Your code here along with comments explaining your approach
class Solution {
    // Approach is to check if length is 1 then only element index is returned
    // else if mid is greater than next element run binary search on left half
    // else run binary search on right half until only 1 element is remaining which is returned
    public int findPeakElement(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        if(nums.length==1) {
            return 0;
        }
        while(l<h) {
            int mid = l+ (h-l)/2;
            if(nums[mid]> nums[mid+1]) {
                h = mid;
            } else {
                l = mid+1;
            }            
        }
        return l;
    }
}
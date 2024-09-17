// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            int m = (mid+nums.length)%nums.length;
            int b = (mid-1+nums.length)%nums.length;
            int a = (mid+1+nums.length)%nums.length;
            if(nums[m]<nums[b]&&nums[m]<nums[a]) {
                return nums[mid];
            }
            if(nums[mid]<nums[0]) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return nums[0];
    }
}
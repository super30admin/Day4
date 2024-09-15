// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Struggled in edge cases


// Your code here along with comments explaining your approach
// use binary search. if mid is less than mid-1 element then its smallest element. take care when mid is 0.
// if l>r then l is smallest


class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(mid>0 && nums[mid] < nums[mid-1]) return nums[mid];
            if(nums[mid] <= nums[r]){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return nums[l];
    }
}
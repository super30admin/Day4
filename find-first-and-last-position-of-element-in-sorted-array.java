// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// find target by binary dearch. then find leftmost and right most same element by binary search;


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid = 0;
        while(l<=r){
            mid = l + (r-l)/2;
            if(nums[mid] == target){
                return new int[]{findLeft(nums,mid),findRight(nums,mid)};
            }
            if(nums[mid]>target){
                r = mid-1;
            } else {
                l = mid +1;
            }
        }
        return new int[]{-1,-1};
    }
    
    private int findLeft(int[] nums, int index){
        int r = index;
        int l = index -1;
        while(r>0 && nums[r]==nums[r-1]){
            if(nums[l]==nums[r]){
                r = l;
                l /= 2;
            } else {
                r -= 1;
                l = r-1;
            }
        }
        return r;
    }
    private int findRight(int[] nums, int index){
        int l = index;
        int r = index  + 1;
        while(l<nums.length-1 && nums[l]==nums[l+1]){
            if(nums[l]==nums[r]){
                l= r;
                r *= 2;
                r = r>nums.length-1?nums.length-1:r;
            } else {
                l += 1;
                r = l+1;
            }
        }
        return l;
    }
    
}
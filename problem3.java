// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// find the mid value and check if that is peak element or not.if yes return mid else check left element of mid is greatre check for peack element in left
// array otherwise righ array.
class Solution {
    public int findPeakElement(int[] nums) {
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if((mid == nums.length-1 ||nums[mid]>nums[mid+1]) && (mid==0 ||                                     nums[mid]>nums[mid-1]))
                return mid;
            else if(mid > 0 && nums[mid-1] > nums[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }
}

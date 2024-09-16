// Find Peak Element

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null && nums.length-1 == 0) return -1;
        int l =0;
        int h = nums.length-1;
        while(l<=h){
            int mid = l +(h-l)/2;
            if((mid == 0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1
                    || nums[mid] > nums[mid+1]))
                return mid;

            else if (mid>0 && nums[mid-1]>nums[mid])
                h=mid-1;
            else{
                l=mid+1;
            }

        }
        return -1;

    }


}
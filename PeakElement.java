// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
Left most and right most would be negative infinity. The before element of right negative element would
always be greater, and after element of left negative element would be greater. So, we can chose to traverse
to either left or right half by checking first greater value(either left or right) of mid. Then we can choose
that path. Definitely we would find a peak element to right side, and we may or may not find towards left.
If the left half is sorted then we cannot find the peak element.
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if((mid==0||nums[mid]>nums[mid-1]) && (mid==nums.length-1||nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(mid>0 && nums[mid]<nums[mid-1]){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }

        return -1;
    }
}
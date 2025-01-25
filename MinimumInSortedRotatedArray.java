// Time Complexity : O(log(n)) n is the no of elements
// Space Complexity : O(1) no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
Few properties
if nums[low] < nums[high] : array is already sorted , nums[low] is the min element
else there is a pivot based on which the rotation happened
[4,5,6,7,0,1,2,3]
there is an increase from 4 -> 7
there is an increase from 0 -> 3
using these observations, we can find the min element
*/

class MinimumInSortedRotatedArray {
    public int findMin(int[] nums) {
        int n=nums.length;

        int left=0;
        int right=n-1;

        if(nums[left]<=nums[right]){
            return nums[left];
        }

        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }

            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }

            if(nums[left]<nums[mid]){
                left=mid+1;
            } else {
                right=mid-1;
            }
        }

        return Integer.MAX_VALUE;

    }
}


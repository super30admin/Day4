// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

/*
Approach:
1. Intuition is that if an element is bigger than itself, one of the peaks would definitely be on that side. 
2. Perform binary search on that side if larger element is found.If not, apply binary search on the other side till peak is found
*/


class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while( low < high ) {
            int mid = low + (high - low) /2;
            if(nums[mid] < nums[mid+1]) 
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
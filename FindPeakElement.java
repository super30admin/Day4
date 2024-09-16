// Time Complexity : The time complexity is O(log(n)) where n is the length of array because for every iteration the search space is divided by half
// Space Complexity : The space complexity is O(1) since no extra space is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findPeakElement(int[] nums) {

        int n = nums.length;

        if(n == 1 || nums[0] > nums[1]){
            return 0;
        }

        if(nums[n-1] > nums[n-2]){
            return n-1;
        }

        int start = 1;
        int end = n-2;

        while(start < end){

            int mid = (end-start)/2 + start;

            // If we find the peak element, return the current index
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }
            // If the element on the right is greater than current element, it means there will be a peak to the right.
            // Therefore, search in the right part
            else if(nums[mid] < nums[mid+1]){
                start = mid+1;
            }
            // If the element on the left is greater than current element, it means there will be a peak to the left.
            // Therefore, search in the left part
            else{
                end = mid-1;
            }
        }

        return -1;

    }
}

// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/* perform binary search taking low = 0 and high = lengh of the array*/
class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high) {
            int mid = low + (high - low)/2;
            if(nums[mid] < nums[high])
             high = mid;
             else
             low = mid + 1;
        }
        return nums[low];
    }
}
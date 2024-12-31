/* Description: So every time we move in the direction in which the neighbour is having higher value, 
 * it is more likely that we get the peak in that side. This is the idea behing code.
 */
// Time Complexity : O(log n) - performing binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes. I wrote the same code(commented below). Just I checked for prior neighbor condition as shown in commented code and I am getting error in one of the testcase. I dont understand what's wrong.

// Your code here along with comments explaining your approach:
// This solution works fine
class Solution {
    public int findPeakElement(int[] nums) {
        // Checking for base condition
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        // Set the low and high value to start binary search
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        // When low is less than or equal to high, come out of the loop
        while (low <= high) {
            // Calculate the mid in below way to avoid integer overflow exception
            int mid = low + (high - low) / 2;
            // Check if the mid itself is peak by comparing it with previous and next
            // element, return mid if it is peak
            if ((mid == low || nums[mid] > nums[mid - 1]) && (mid == high || nums[mid] > nums[mid + 1])) {
                return mid;
            }
            // Else check which neighbor is having higher value and move to that part
            else if (nums[mid + 1] > nums[mid]) {
                // Move to right
                low = mid + 1;
            } else {
                // Move to left
                high = mid - 1;
            }
        }
        return 555555;
    }
}

// Commented code - else if condition of prior neighbor:
// This solution does not work fine
// class Solution {
// public int findPeakElement(int[] nums) {
// if(nums.length==0||nums==null){
// return -1;
// }
// int low=0;
// int n=nums.length;
// int high=n-1;

// while(low<=high){
// int mid=low+(high-low)/2;
// if((mid==low||nums[mid]>nums[mid-1]) && (mid==high||nums[mid]>nums[mid+1])){
// return mid;
// }else if(nums[mid]<nums[mid-1]){ //............only this condition
// high=mid-1;
// }else{
// low=mid+1;
// }
// }
// return 555555;
// }
// }
// Time Complexity : O(logN) - N is size of the array
// Space Complexity : O(1) - No extra data structure is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Here to have a better time complexity used Binary Search by having two pointers and a mid value;
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        if(nums[0] < nums[right]) return nums[0];
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if(nums[mid - 1] > nums[mid]) return nums[mid];
            if(nums[mid] > nums[0]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
// Your code here along with comments explaining your approach

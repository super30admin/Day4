// Time Complexity : O(logN) - N is size of the array
// Space Complexity : O(1) - No extra data structure is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Here to have a better time complexity used Binary Search by having two pointers and a mid value;
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int left = 0,right = nums.length - 1;
        while(left <= right){
            if( left == right) return left;
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[mid + 1]) right = mid;
            else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
// Your code here along with comments explaining your approach

// Time Complexity :O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
Approach using binary search by moving on to the minimum value side
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1, mid = 0;
       while(left < right){
           mid = left + (right - left)/2;
            if(nums[mid] > nums[right]) left = mid+1;
            else right = mid;  
       }
        return nums[left];
    }
}

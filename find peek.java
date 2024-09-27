// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l<=h){
            int mid = l + (h-l)/2;
            if(nums == null &&  nums.length == 0) return -1;
            if(nums.length == 1) return 0;
            if(0 == mid && (nums[mid] > nums[1])) return mid;
            if((nums.length - 1 == mid) && (nums[mid] > nums[mid - 1])) return mid;
            if ((nums[mid] > nums[mid + 1]) && (nums[mid] > nums[mid - 1])) return mid;
            if(nums[mid] < nums[mid + 1]){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
    return -1;
    }
}
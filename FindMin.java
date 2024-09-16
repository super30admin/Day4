// Time Complexity : The time complexity is O(log(n)) where n is the length of array because for every iteration the search space is divided by half
// Space Complexity : The space complexity is O(1) since no extra space is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;

        if(n == 1 || nums[0]<nums[nums.length-1]){
            return nums[0];
        }

        int start = 0;
        int end = n - 1;

        while(start < end){

            int mid = (end-start)/2 + start;

            // If the current element is geater than the end, it means there is a rotation in right part
            if(nums[mid] > nums[end]){
                start = mid+1;
            }
            // If the current element is less than the end, it means there is a rotation in left part
            else{
                end = mid;
            }
        }

        return nums[start];

    }
}
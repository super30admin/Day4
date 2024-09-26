// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;
        
        if (nums[high] > nums[low]) { // check if rotation is there or not
            return nums[0];
        }
        while(low <= high){
            int mid = low + (high - low) / 2; 

            if(nums[mid] > nums[mid + 1]){ // 1st base to check if next element is smaller
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {// 2nd base to check if previous element is bigger
                return nums[mid];
            }
            if(nums[mid] > nums[low]){// finding the sorted part to find the unsorted part
                low = mid + 1;             
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
// Time Complexity : O(logN+logN) = O(2logN) = O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
Intially we have found the low element, then we have to find the last element. When finding the first element,
we have traverse to left until we don't have the target element. After finding the left most target element,
we will follow similar pattern to search for the right most element.
 */

class Solution {

    public int lowBinarySearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid]==target){
                if(mid==0||nums[mid]>nums[mid-1]){
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return -1;
    }

    public int lastBinarySearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid]<nums[mid+1]){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if(nums[mid]>target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[] {-1, -1};
        int low = 0;
        int high = nums.length - 1;

        if(nums[low]>target || nums[high]<target) return new int[] {-1, -1};
        int lowIndex = this.lowBinarySearch(nums, low, high, target);

        if(lowIndex == -1) return new int[] {-1, -1};

        int highIndex = this.lastBinarySearch(nums, lowIndex,high, target);
        return new int[] {lowIndex, highIndex};
    }
}
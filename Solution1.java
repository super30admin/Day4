//time complexity: O(logn)
//space complxity: O
//#34. Find First and Last Position of Element in Sorted Array

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[low] <= nums[mid]){
                //left half is sorted
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if(nums[mid] <= nums[high]){
                //right half is sorted
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
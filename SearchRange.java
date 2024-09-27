/**
*Find First and Last Position of Element in Sorted Array
* Time complexity O(logn)
* Space complexity O(1)
* Once you find the left index, search the left side till you find the left most index. 
* Similarly search the right side
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = -1, right = -1;
        if (nums == null || nums.length == 0){
            return  new int []{left, right};
        }
        left = findLeftIndex(nums, target);
        right = findRightIndex(nums, target);
        return new int[] {left, right};
    }
    
    public int findLeftIndex(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right)
        {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                if ((mid - 1 >= 0 )&& nums[mid-1] == nums[mid])
                {
                    right = mid -1;
                }
                else
                {
                    return mid;
                }
            }
            else if (nums[mid] > target)
            {
                 right = mid - 1;
            }
            else
            {
               left = mid + 1;
            }
        }
        return -1;
    }
    
    public int findRightIndex(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right)
        {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                if ((mid + 1 <= nums.length-1) && nums[mid+1] == nums[mid])
                {
                    left = mid + 1;
                }
                else
                {
                    return mid;
                }
            }
            else if (nums[mid] > target)
            {
                 right = mid - 1;
            }
            else
            {
               left = mid + 1;
            }
        }
        return -1;
    }
}

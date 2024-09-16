class Solution {
    int first;
    private int searchFirstIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            //if the element at the mid is equal to target
            if(nums[mid] == target) {
                //and if the element left of the mid is less than mid or mid index is 0, 
                //then we have found the first index of the target.
                if(mid == 0 || nums[mid - 1] < nums[mid]) {
                    return mid;
                }
                //else we will keep searching on the left of the mid.
                else {
                    right = mid - 1;
                }
            }
            //if the elememt at mid is greater than target, the target lies on the right of the mid.
            else if(nums[mid] > target) {
                right = mid - 1;
            }
            //else the target lies on the left of the mid.
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int searchLastIndex(int[] nums, int target) {
        int left = first;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            //if the element at the mid is equal to target
            if(nums[mid] == target) {
                //and if the element right of the mid is greater than mid or mid is at the last index, 
                //then we have found the last index of the target.
                if(mid == nums.length - 1 || nums[mid + 1] > nums[mid]) {
                    return mid;
                }
                //else we will keep moving right as we have found our first index.
                else {
                    left = mid + 1;
                }
            }
            //if the elememt at mid is greater than target, the target lies on the right of the mid.
            else if(nums[mid] > target) {
                right = mid - 1;
            }
            //else we will keep searching on the left of the mid.
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        //If there are no elements in the array, return {-1, -1};
        if(nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        //As it is an sorted array, if the target is less than the first element of the array
        //or if the target is greater than the last element, that means target is not present in the array.
        if(target < nums[0] || target > nums[nums.length-1]) {
            return new int[] {-1, -1};
        }
        //we will search the first index at first
        first = searchFirstIndex(nums, target);
        if(first == -1) {
            return new int[] {-1, -1};
        }
        //then we will search the last index 
        int last = searchLastIndex(nums, target);
        return new int[] {first, last};
    }
}
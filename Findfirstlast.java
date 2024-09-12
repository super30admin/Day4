// Time Complexity : The time complexity will be O(log (n) +log(n)) since we are searching the left most and right most using two different functions and dividing the search space into half
// Space Complexity :It doesnt require any extra space so O(1)
// Did this code successfully run on Leetcode :yes  
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {

    public int leftSearch(int[] nums, int left, int right, int target) {

        while (right >= left) {
            int mid = left + (right - left) / 2;
            // if we found the element check if it is the left most or not
            if (nums[mid] == target) {
                // we see if this is the the left most index (either leftmost index of our sub
                // array or if nums[mid-1] < target which means no point in going left)
                if (left == mid || nums[mid - 1] < target) {
                    return mid;
                }
                // shorten our array by halfing it till mid
                else
                    right = mid - 1;
            }
            // else continue our normal binary search
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public int rightSearch(int[] nums, int left, int right, int target) {

        while (right >= left) {
            int mid = left + (right - left) / 2;
            // if we found the element check if it is the right most or not
            if (nums[mid] == target) {
                // we see if this the right most index (either rightmost index of our sub array
                // or if nums[mid+1] < target which means no point in going left)
                if (right == mid || nums[mid + 1] > target) {
                    return mid;
                } else
                    // shorten our array by halfing it from mid till end
                    left = mid + 1;
            }
            // else continue our normal binary search
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int left = leftSearch(nums, 0, nums.length - 1, target);
        int right = rightSearch(nums, 0, nums.length - 1, target);

        return new int[] { left, right };
    }

}
// Time Complexity: O(log n) where n is the number of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


// Your code here along with comments explaining your approach
class FindFirstAndSecondElement {
    public int[] searchRange(int[] nums, int target) {

        //base case
        if(nums == null || nums.length == 0) return new int[]{-1,-1};

        //if the element is not in the sorted array range
        if(target < nums[0] || target > nums[nums.length-1]) return new int[]{-1, -1};

        //if the first occurrence of the element is -1, then that element doesn't exist in the array
        int first = binarySearchFirstOccurence(nums, target);
        if(first == -1) {
            return new int[]{-1, -1};
        }
        int last = binarySearchLastOccurence(nums, target);

        //return the first and last occurrence of the element
        return new int[]{first, last};
    }

    //binary search for the first occurence of the target element
    public int binarySearchFirstOccurence(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        //binary search to search the target
        while(low <= high) {
            int mid = low + (high-low)/2;

            //if the element if found
            if(nums[mid] == target) {
                //if the element is not equal to the previous element, then it is the first element, return it
                if(mid == 0 || nums[mid] != nums[mid-1]) {
                    return mid;
                } //reduce the high to search for the first element
                else {
                    high = mid -1;
                }
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        //if the element is not found
        return -1;
    }

    //binary search for the last occurence of the target element
    public int binarySearchLastOccurence(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        //binary search to search the target
        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid] == target) {
                //if the element is not equal to the next element, then it is the last element, return it
                if(mid == nums.length-1 || nums[mid] != nums[mid+1]) {
                    return mid;
                } //increase the low to search for the last element
                else {
                    low = mid+1;
                }
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        //if the element is not found
        return -1;
    }
}
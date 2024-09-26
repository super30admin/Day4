// Time Complexity : O(logn) ;(n is the no.of elements in array) as atleast one side of the array will be sorted which will reduce search space by half as we will ignore the sorted side of array 
// Space Complexity : O(1) ; no auxilary space needed
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//CODE

class Find_min_in_rotated_sorted_array {
    public int findMin(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length - 1; // initially taking low and high as first and last index of given array
                                    // respectively
        while (low <= high) {

            int mid = low + (high - low) / 2; // avoiding integer overflow
            if (nums[low] <= nums[high])
                return nums[low]; // if elemet at low is smaller than element at high index then it means the
                                  // array is sorted , so element at low index will be the minimum
            if ((mid == nums.length || nums[mid] < nums[mid + 1]) &&
                    (mid == 0 || nums[mid] < nums[mid - 1])) { // condition for minimum element including edge cases
                                                               // i.e. if mid is at first and last index
                return nums[mid];
            } else if (mid != nums.length && nums[low] <= nums[mid]) { // if sub-array is left sorted ,then ignore left
                                                                       // part and search in right side
                low = mid + 1;
            } else { // else subarray is right sorted , then ignore right side and search in left
                     // side
                high = mid - 1;
            }
        }
        return 789;
    }
}
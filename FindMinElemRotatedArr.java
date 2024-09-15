// Time Complexity : O(Log n); as we are splitting till the mid point and choosing direction to search
// Space Complexity : O(1); except variables not using any extra space.
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/636462979/)
// Any problem you faced while coding this : No;
// My Notes : The idea is everytime you break the arr; you point towards mid and check if it is the pivot elem (if prev elem is less than the current mid). 
public class FindMinElemRotatedArr {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        // Applying normal iterative binary search conditions
        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println(" Vars : start,mid,end : " + start + " , " + mid + ", " + end);

            // If arr is already sorted or there is only 1 elem (start and end will be same)
            // then return the first elem
            if (nums[start] <= nums[end]) {
                return nums[start];
            }

            // If the element is pivot; then return that, check mid if nonzero to avoid index out of bound exception
            if (mid != 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[end]) {
                // left sorted so search in right array
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                // right sorted so search in left array
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMinElemRotatedArr obj = new FindMinElemRotatedArr();
        int[] nums = { 11, 13, 15, 17 };
        System.out.println(obj.findMin(nums));
    }
}

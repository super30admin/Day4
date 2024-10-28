// Time Complexity : O(log n) as we are using binary search
// Space Complexity : O(1) Constant space as the amount of extra space used does not depend on number of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// peak element  is greater than both left and right neighbour
// we will try to move towards the greater slope and keep eliminating the lesser one
// if we have high slope on both sides, we can move to either sides, both will give us peaks
public class FindPeakElement {
    public int findPeakElement(int [] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1])) {// check if mid is the peak
                return mid;
            } else if (mid>0 && nums[mid] < nums[mid - 1]) {/// check whether we have greater slope on left half of array
                high = mid - 1; // left slope is greater

            } else {
                low = mid + 1; // else right neighbour is greater
            }
        }
        return -1;
        }

        public static void main(String[] args) {
            FindPeakElement solution = new FindPeakElement();
            int[] nums = {1, 2, 1, 3, 5, 6, 4};
            int result = solution.findPeakElement(nums);
            System.out.println("Peak element index: " + result);
            System.out.println("Peak element value: " + nums[result]); // Display the peak value
        }
        }




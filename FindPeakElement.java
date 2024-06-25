/*
    1. Time Complexity : O(log(n))
    2. Space Complexity : O(1)   
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */

/*
 * Binary search
 * For each iteration check if nums[mid] greater than its neighbors.
 * If yes, return mid
 * If no, then compare nums[mid] with right neighbor,
 *          if greater, eliminate left half and move low = mid + 1;
 *          else, eliminate right half and move high = mid - 1;
 * Move towards the increasing half of the array for each iteration
 */

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int l = 0, h = nums.length - 1, mid;
        while (l <= h) {
            mid = l + (h - l) / 2;
            if ((mid == h || nums[mid] > nums[mid + 1]) &&
                (mid == 0  || nums[mid] > nums[mid - 1]))
                return mid;
            else if (nums[mid] < nums[mid + 1])
                l = mid + 1;
            else
                h = mid - 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        // int[] nums = {1,2,1,3,5,6,4};
        int[] nums = {6,5,4,3,4,7,6};
        System.out.println("Peak is:"+nums[findPeakElement(nums)]);
    }
}

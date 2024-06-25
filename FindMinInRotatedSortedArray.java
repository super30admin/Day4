/*
    1. Time Complexity : O(log(n))
    2. Space Complexity : O(1)   
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */

/*
 * Binary search
 * for each iteration check if nums[mid] >= nums[low].
 * if yes, check if nums[mid] > nums[high]:
 *          if yes, then left half is sorted and so minimum element is on the right half, so move low = mid + 1;
 *          if no, then entire range is sorted, so return nums[low]
 * if no, then right half is sorted and so minimum element is on the left half, so move high = mid;
 */

public class FindMinInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int l = 0, h = nums.length - 1, mid;
        while (l < h) {
            if (nums[l] <= nums[h]) break;
            mid = l + (h - l) / 2;
            if (nums[mid] >= nums[l]) {
                if (nums[mid] > nums[h])
                    l = mid + 1;
                else
                    break;
            } else
                h = mid;
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,1,2};
        // int[] nums = {11,13,15,17};
        System.out.println("Min is: "+ findMin(nums));
    }
}

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. We use the concept that the array is rotated.
 * 2. since the array is rotated, when we divide the array into half the min element is located in non-sorted part of the array.
 * 3. If the middle element is not the minimum value then we move the search space to non-sorted array.
 * 4. At any point of time, after moving to the non-sorted section of the initial array 
 *    and we find the sub array to be sorted, then we can return the initial element as minimum.
*/

public class MinEleRotSortArr {
    
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int low = 0, high = nums.length - 1;

        while (low <= high) {

            // If the array is sorted from low -> high, return the lowest element.
            if (nums[low] <= nums[high]) return nums[low];

            int mid = low + (high - low) / 2;

            // Check if the middle element is the minimum value.
            if ((mid == 0 || nums[mid] < nums[mid - 1]) &&
                    (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }

            if (nums[low] <= nums[mid]) {
                // left half of the array is sorted
                low = mid + 1;
            } else {
                //right half of the array is sorted
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
        System.out.println(findMin(new int[]{4,5,1,2,3}));
    }
    
}

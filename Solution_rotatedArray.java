/* 
Time Complexity :  log(n)
Space Complextiy : O(1)
*/

class Solution_rotatedArray {
    public int findMin(int[] nums) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;
//  checking boundary cases and element of left and right 
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {

                return nums[mid];

            }

            else if (nums[lo] <= nums[mid] && nums[mid] > nums[hi]) {

                lo = mid + 1;
            }

            else {

                hi = mid - 1;
            }
        }

        return -1;
    }
}
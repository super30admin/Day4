// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class FindMinimum {

        public int findMin(int[] nums) {

            // If the list has just one element then return that element.
            if (nums.length == 1) {
                return nums[0];
            }

            // initializing left and right pointers.
            int left = 0, right = nums.length - 1;

            // if the last element is greater than the first element then there is no rotation.
            if (nums[right] > nums[0]) {
                return nums[0];
            }

            while (right >= left) {

                int mid = left + (right - left) / 2;

                // if the mid element is greater than its next element then mid+1 element is the smallest
                // This point would be the point of change
                if (nums[mid] > nums[mid + 1]) {
                    return nums[mid + 1];
                }

                // if the mid element is lesser than its previous element then mid element is the smallest
                if (nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                }

                // if the mid elements value is greater than the 0th element, the min value is to the right
                if (nums[mid] > nums[0]) {
                    left = mid + 1;
                } else {
                    // if greater than the mid, then the smallest value is to the left
                    right = mid - 1;
                }
            }
            return -1;
        }
}

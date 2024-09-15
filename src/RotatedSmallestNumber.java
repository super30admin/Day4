/**
 * 153. Find Minimum in Rotated Sorted Array
 * Time Complexity : O(log n)
 * Space Complexity: O(1)
 * Using binary search find the min ele and return it.
 */
public class RotatedSmallestNumber {
    /**
     * Since the array is sorted and is rotated at some point, first chk if the left subarray (before mid) is sorted and if so take the min of the first ele
     * and if the mid+1 ele is smaller then that is the rotated point and hence return it.
     * If not check in the right subarray(after mid)
     * @param nums
     * @return min ele in the gvn array nums
     */
        public int findMin(int[] nums) {
            int left = 0, right = nums.length-1, min = Integer.MAX_VALUE;
            while(left <= right){
                int mid = left + (right-left)/2;
                if(nums[left] <= nums[mid]){                               //if left part of the array is sorted
                    if(mid!=nums.length-1 && nums[mid] > nums[mid+1])      // comp ele at mid and mid+1, if mid+1 ele is smaller then its the smallest ele in the array
                        return nums[mid+1];
                    min = Math.min(min, nums[left]);
                    left = mid+1;                                         //move the left ptr to mid+1 to search for the right subarray
                }else                                                     //if left subarray is not sorted then definitely the smallest ele is in that part
                    right = mid-1;

            }
            return min;
        }
}

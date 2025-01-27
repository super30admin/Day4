/* Time Complexity : O(log n) because we are eliminating 1/2 of the array everytime based on the mid.
 * Space Complexity : O(1)
 * leetcode : yes
 * Any Problems : no
 */
class Solution {
    public int findMin(int[] nums) {
        int low =0;
        int high = nums.length-1;
        int min = Integer.MAX_VALUE;
        //using divide and conquer
        while(low<=high)
        {
            //calculated the mid
            int mid = low + (high-low)/2;
            //checking if the left subarray is sorted, if sorted then we update the min with the element at low index.
            // we check for the min element in the right subtree.
            if(nums[mid] >= nums[low])
            {
                min = Math.min(nums[low], min);
                low = mid+1;
            }
            //meas the right part is sorted, we update the mid with mid and then check for the min in the unsorted part of the array.
            else
            {
                min = Math.min(nums[mid], min);
                high = mid-1;
            }
        }
        //return the minimum finally.
        return min;
    }
}
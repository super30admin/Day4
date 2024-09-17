/*
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Any problem faced while coding this:
 * */
class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while(low < high){
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }
}
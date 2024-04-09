
/**
 * Time Complexity-O(logN), Space Complexity- O(1)
Check if the rotated sorted array is properly sorted as an edge case
(low<=high)

Min value -> Middle is less than both sides adjacent.

Check for which part is sorted and unsorted.
See where the minimum lies-> always in the unsorted part


 */
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1;

        while(low<=high){
        if(nums[low]<=nums[high]){
            return nums[low];
        }
            int mid = low+(high-low)/2; //to avoid integer overflow
            if(nums[mid]<nums[mid+1] && nums[mid]<=nums[mid-1]){
                return nums[mid];
            }
            else if(nums[mid]>=nums[low]){
                low=mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
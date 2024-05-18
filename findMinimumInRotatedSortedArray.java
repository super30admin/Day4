/* Approach : Since a sorted array is rotated, we can safely assume that atleast half of the rotated array is sorted.
                And also the lowest element most probably will be on the unsorted half
 *  Step1 : Check for value in the middle and compare it with elements on right and left
 *  Step2:  Checking for sorted half on either sides and continue to the other side to search minimum value
 *  
 *  Time Complexity: O(log n) 
 *  Space Complexity: constant O(1)
 */
class Solution {
    public int findMin(int[] nums) {
        //ATLEAST one side is sorted when divided the array is half

        if(nums == null || nums.length == 0) return -1;

        /* split into sorted and unsorted side, unsorted side has the smallest element
        always check the unsorted side
        */

        int len = nums.length;
        int low = 0;
        int high = len - 1;

        while(low <= high) {
            if(nums[low] <= nums[high])
                return nums[low];
            int mid = low + (high - low)/2; // prevent integer overflow in java
            if((mid == low || nums[mid - 1] > nums[mid]) &&
                (mid == high || nums[mid+1] > nums[mid] )){
                return nums[mid];
            }
            if(nums[low] <= nums[mid]){
                low = mid + 1;
            }  
            else{
                high = mid - 1;
            }
        }
    return -1;
    }
}

/** Time Complexity: O(logN)
 ** Space Complexity: O(1)
 **/ 

class Solution {                            // Array would always be rotated on smallest number and smallest number would always fall on non sorted side
    public int findMin(int[] nums) {
        int low = 0; int high = nums.length - 1;int mid;
        while(low <= high){
            if(nums[low] <= nums[high]) return nums[low];       // if the first element is the smallest in sorted array
            mid = low + (high - low)/2;

            // Edge Cases: mid==0 , mid == nums.length - 1; Rest two conditions to ensure that mid is poining to smallest
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length-1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            } else if(nums[low] <= nums[mid]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 1490; 
    }
}
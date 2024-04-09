// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
public class FindMinimumOfArrayLC153 {

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (high == 0)
            return nums[0];
        while (low <= high) {
            if(nums[low]<=nums[high]) return nums[low];

            int mid = low + (high - low) / 2;
            // Property of min element is: eg[3,4,5,1,2]
            // ie =>nums[left]>nums[mid]<nums[right]
            // all other elements are left is <mid<right.

            if ((mid == 0 || nums[mid] < nums[mid - 1])
             && (mid == high || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }  else if(nums[low] <= nums[mid]){//checking if left part is sorted?yes, go to right side.
                 // here the logic is: min element always lies on the unsorted part.
                //so move low to right side.
                low = mid + 1;
            } else{ //go to left side by setting high as mid-1
                high = mid - 1;
            }

        }
        return -1;
    }
}

// YT link:https://youtu.be/TQuyNmM5-pg
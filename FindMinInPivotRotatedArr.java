// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Missed to check Low < high // already sorted part
//

public class FindMinInPivotRotatedArr {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int low = 0;
        int high = nums.length -1;

        while(low<=high) {
            if (nums[low] < nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low)/2;
            //Pivot point
            if ( (mid == 0 || nums[mid] < nums[mid-1])
                    && (mid == nums.length - 1 || nums[mid] < nums[mid+1])
            ) {
                return nums[mid];
            }else if(nums[low] > nums[mid]){ //Left side unsorted
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }//end of while
        return -1;
    }
}

//Finding the minimum element by performing binary search. Minimum out of left and sorted will be returned.


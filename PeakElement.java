// Time Complexity : 0(log n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Keep in mind edge conditions like mid == 0, mid == length-1

class PeakElement {
    public int findPeakElement(int[] nums) {

        if(nums == null || nums.length == 0)
            return -1;

        int low = 0, high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            //if mid is greater than both neighbours return mid
            if((mid == 0 || nums[mid] > nums[mid-1]) &&
                    (mid == nums.length - 1 || nums[mid] > nums[mid+1]))
                return mid;

            //if left of mid is higher, shift high
            else if(mid > 0 && nums[mid] < nums[mid -1])
                high = mid - 1;

            //if right of mid is higher, shift left
            else
                low = mid + 1;
        }

        return -1;
    }
}
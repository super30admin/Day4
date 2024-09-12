// Time Complexity : O(log n) where n is the number of elements in input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class FindingPeak {
    public int findPeakElement(int[] nums) {

        //Null check
        if(nums == null || nums.length == 0){
            return -1;
        }

        int low = 0;
        int high = nums.length -1;

        while (low <= high){
            int mid = low + (high-low)/2;

            //mid is peak element and mid could be first element or mid is the last element
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length -1 || nums[mid] > nums[mid+1])){
                return mid;
            }

            // left side
            else if(mid >0 && nums[mid-1] > nums [mid]){
                high = mid -1;
            }

            //right side
            else {
                low = mid+1;
            }
        }
        return -1;
    }
}
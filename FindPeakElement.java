// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, followed the approach as discussed in class


// Your code here along with comments explaining your approach in three sentences only
// After calculating the mid of the array, check if mid is greater than its neighbours
// If not, continue finding peak element on the side which has the greater element than the mid element

public class FindPeakElement {
        public int findPeakElement(int[] nums) {
            if(nums == null || nums.length == 0){
                return -1;
            }

            int low =0;
            int high = nums.length -1;
            while(low<=high){
                int mid = low + (high-low)/2;
                if((mid == low || (nums[mid] > nums[mid-1])) && (mid == high || (nums[mid] > nums[mid+1]))){
                    return mid;
                }
                if(nums[mid+1] > nums[mid]){
                    low = mid+1;
                }else if(nums[mid-1] > nums[mid]){
                    high = mid-1;
                }
            }
            return 7879;
        }
}

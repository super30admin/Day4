// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, followed the approach as discussed in class


// Your code here along with comments explaining your approach in three sentences only
// After calculating the mid of the array, check if left half is sorted , if it is sorted , find the min in the right half(which is unsorted)
// If left half is not sorted, find min in the left half

public class FindMinimumInRotatedArray {
        public int findMin(int[] nums) {
            if(nums == null || nums.length == 0){
                return -1;
            }

            int low =0;
            int high = nums.length -1;
            while(low<=high){
                if(nums[low]<= nums[high]){
                    return nums[low];
                }
                int mid = low +(high-low)/2;

                if(((mid == low)|| (nums[mid-1] > nums[mid] )) && ((mid == high) || (nums[mid+1] > nums[mid]))){
                    return nums[mid];
                }
                if(nums[low]<= nums[mid]){
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
            return -1;
        }
}

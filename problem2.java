// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// first we check if whole array is sorted return 1st element, if not calcule the middle element. if right side of array is sorted make end equal to end 
// else make start equal to mid +1 because since its rotated array, min value should be part on no sorted half of array.
class Solution {
    public int findMin(int[] nums) {
        int start=0,end=nums.length-1;
       while (start < end) {
            if (nums[start] < nums[end]) {
                return nums[start];
            }

            int mid = start + (end - start) / 2;
            if (nums[mid] <= nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }
}

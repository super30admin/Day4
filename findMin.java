// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        int mid = 0;
        //O(log N)
        while(low<=high) {
            if(nums[low] <= nums[high])
                return nums[low];
            mid = low+(high - low)/2;
            if(nums[low] <= nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return nums[mid];
    }
}
//Initial Try
// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
 class Solution {
     public int findMin(int[] nums) {
         int low = 0;
         int high = nums.length -1;
         int indexOfLowValue = 0;
         //O(log N)
         while(low<=high) {
             int mid = low+(high - low)/2;
             System.out.println(high);
             if(nums[low] <= nums[mid]) {
                 if(nums[indexOfLowValue] > nums[mid])
                     indexOfLowValue = low;
                 low = mid + 1;
             }
             else {
                 if(nums[indexOfLowValue] > nums[mid])
                     indexOfLowValue = mid;
                 high = mid - 1;
             }
         }
         return nums[indexOfLowValue];
     }
 }
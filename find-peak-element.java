// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only:
//  I used a binary search approach to find the peak element in an array. 
// I start by calculating the middle index mid.
//  If nums[mid] is greater than both of its neighbors, it is a peak, and I return mid.
//  Otherwise, I compare nums[mid] with nums[mid + 1]. If nums[mid] < nums[mid + 1],
//  a peak must exist on the right side since elements in nums are always greater than those outside.
//  So, I update low = mid + 1, effectively ignoring the left half. Otherwise, I search in the left half
//  by setting high = mid - 1. This process continues, reducing the search space until the peak element is found.
class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length;
        if(nums.length == 1){
            return nums[0];
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if( (mid == 0 || nums[mid]>nums[mid-1] )&& 
              (mid == high || nums[mid]> nums[mid+1])){
              return mid;
            }else{
                if(nums[mid] < nums[mid+1]){
                     low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return 99999;
    }
}
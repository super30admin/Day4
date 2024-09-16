/*
Time complexity : O(log N) as only one side of the array is searched.
Space Complexity : O(1)
*/
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            //check if the mid element is the peak by comparing the mid element with its left and right elements
            //mid==0 is checked to see if the mid is the first element and mid == nums.length is checked to determine if mid is the last element
            if((mid==0 || nums[mid]>nums[mid-1])&&( mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            // go towards the increasing order of elements as the probablity of finding the peak is more on the ascendomg order of the elements rather than decreasing and accordingly set the kow and high
            if(nums[mid]<nums[mid+1]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}
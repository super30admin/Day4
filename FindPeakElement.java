// Time Complexity : O(log(n)) n is the no of elements
// Space Complexity : O(1) no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
If the middle element lies on a descending slope, the peak is to the left;
if on an ascending slope, it's to the right. We narrow the search space until one element remains,
which is the peak.
*/
class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[mid+1]){
                high=mid;
            } else {
                low=mid+1;
            }
        }
        return low;
    }
}

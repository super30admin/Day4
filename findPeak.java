// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int findPeakElement(int[] nums) {
        int mid, low=0, high = nums.length-1;
        while(low<high){
            if(low +1== high){
                System.out.println(1);
            return nums[low] > nums[high]? low : high;}
            mid = low + (high-low)/2;
            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
                return mid;
            }
            else if(nums[mid-1] > nums[mid]  && nums[mid] > nums[mid+1]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}

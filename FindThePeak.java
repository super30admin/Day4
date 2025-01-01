// Time Complexity :O log(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
// Go in the direction of a larger neighbour, if both neighbours are same go to either side.
//Also, if asked to find all the Peaks, iterate through the array, TC: O(N)
class Solution {
    public int findPeakElement(int[] nums) {

        if(nums == null || nums.length == 0) return -1;
        if(nums.length >= 2  && nums[0] > nums[1]) return 0;

        int low = 0; int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if((mid == 0 || nums[mid] > nums[mid -1]) && (mid == high || nums[mid] > nums[mid + 1] )){
                return mid;

            }

            if(nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return 898098;
        
    }
}
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[low]< nums[high]) return nums[low];
            /* if nums[mid] is less than both its neighbors, then it is the lowest num*/
            //if mid==0 && mid==nums.length-1 --> if the lowest is at first or last element check
            if((mid==0 || nums[mid]<nums[mid-1]) && (mid==nums.length-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            else if(nums[low]<=nums[mid]){//left side of the array is sorted
                //search only in the right side of array
                low=mid+1;
            }
            else{
                //right side is sorted, so search in left side 
                high=mid-1;
            }
        }
        return -1;
    }
}
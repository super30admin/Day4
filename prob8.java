// S30 Big N Problem #8 {Medium}
// 153. Find Minimum in Rotated Sorted Array
// Time Complexity :O(log n)
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
// [4 5 6 7 0 1 2]
// [0 1 2 3 4 5 6]
// [4 5 6 0 1 2 3]
// minimum always lies on the other side of sorted array
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
        	//base case
            if(nums[low]<nums[high]) return nums[low];
            int mid=low+(high-low)/2;
            //case > mid is minimum
            if((low==mid || nums[mid]<nums[mid-1]) && (high==mid || nums[mid]<nums[mid+1])) return nums[mid];
            else if(nums[low]<=nums[mid]){//left array ->sorted
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
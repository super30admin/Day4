// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

class Solution {
    int[] nums;
    
    private int binarySearch(int low, int high){
        int mid = low + (high-low)/2;
        if(nums[mid]>nums[mid+1]) // if next element is min
            return mid+1;
        if(nums[mid]<nums[mid-1]) // if previous element is min
            return mid;
        if(nums[mid]>nums[low]) // if low to mid is sorted
            return binarySearch(mid+1, high);
        else
            return binarySearch(low, mid-1);
    }
    
    public int findMin(int[] nums) {
        this.nums = nums;
        int low =  0;
        int high = nums.length-1;
        
        if(low == high || nums[low]<=nums[high]) // if there is only one element or array already sorted
            return nums[low];
        
        return nums[binarySearch(low, high)];
    }
}
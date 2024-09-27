// Time Complexity : As we are performing binary search and discarding half array each time so O(log(n))
// Space Complexity : Constant space as only few variables are used O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : couldn't identify comparision of mid and neighbour of mid

// Your code here along with comments explaining your approach
class Solution {
    
    // Approach is to check if the array is rotated by checking first and last element
    // if the array is rotated, checking mid value to its neighbours to know if any previous value is more than next value of neighbour, return the smaller value
    // otherwise if left part is sorted, this means initial value will be on the right half
    // so take left pointer to mid+1
    // otherwise right part is sorted, binary search in left part by making high as mid-1
    public int findMin(int[] nums) {
        if(nums.length==1) {
            return nums[0];
        }
        int l = 0;
        int h = nums.length-1;
        if(nums[l]<nums[h]) {
            return nums[l];
        }
        
        while(h>=l) {
            int mid = l+ (h-l)/2;
            if(nums[mid]>nums[mid+1]) {
                return nums[mid+1];
            }
            if(nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            if(nums[mid]>nums[l]) {
                l = mid+1;
            } else {
                h = mid-1;
            }
        }
        return -1;
    }
}
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : It took time for me to understand that we need two if conditions 
// https://leetcode.com/problems/search-in-rotated-sorted-array/


// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        
        if(nums == null || nums.length == 0) return -1; //handling edge case
        if (nums.length == 1) return nums[0]; // handle one element case
        
        int l = 0, h = nums.length - 1;
        if(nums[l]>nums[h]){
            while(l<=h) { 
                int mid = l + (h-l)/2; // to avoid overflow
                
                if(nums[mid] > nums[mid+1]) return nums[mid+1]; //element found
                if(nums[mid-1] > nums[mid]) return nums[mid]; //element found
                
                if(nums[mid] > nums[l]){ //left sorted
                    l = mid + 1;
                } else { //right sorted
                    h = mid - 1;
                }
            }
        } else {
            return nums[0];
        }
        return -1;
    }
}
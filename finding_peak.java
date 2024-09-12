
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english: Brute force is linear search that will help you find as many peaks in the array to imporve the time complexity from O(n) to O(log n) I am using binary search.

// Your code here along with comments explaining your approach


class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length -1 ;
        
        while(low<=high){
            int mid = low+ (high-low)/2;
            
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }else if (nums[mid+1] > nums[mid]){
                // move to the right side
                low = mid +1;
            }else{
                // move to the left side
                high = mid -1;
            }
        }
        return -1;
    }
}
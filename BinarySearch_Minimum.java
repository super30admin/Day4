// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        
        while(start<end){
            int mid = start + (end - start)/2;
            
            if(mid>start && nums[mid]<nums[mid-1]){//if mid is smaller than the previous element
                return nums[mid];
            }
            else if(mid<end && nums[mid]>nums[mid+1]){//if mid is greater than the next element
                return nums[mid+1];
            }
            
            if(nums[mid]>nums[start]){ //left side is sorted and pivot is on the right side
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return nums[0];
    }
}
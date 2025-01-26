// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * 
 * Using binary search find if mid is less than its neighbours, then return that mid index,
 * else if left index is less than mid index(sorted) then min is in right half, else in left half.
 *
 */
class Solution {
    public int findMin(int[] nums) {
        
        int left=0;
        int right=nums.length-1;
        while(left<right){
            //check complete range is sorted
            //also if there is single elment in the range
            if(nums[left]<nums[right]){
                return nums[left];
            }
            int mid=left+(right-left)/2;
            if((mid==0 || nums[mid]<nums[mid-1]) && (nums[mid]<nums[mid+1])){
                return nums[mid];
            }else if(nums[left]<=nums[mid]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return nums[left];
    }
    
}
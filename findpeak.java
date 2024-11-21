// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length ==1 ) return 0;

        int low = 0;
        int high = nums.length -1;

        while(low<=high){
            int mid = low +(high - low)/2;
            if((mid ==0 || nums[mid] > nums[mid-1]) && (mid==nums.length-1 || nums[mid] >nums[mid+1])){
                return mid;
            }
            else if(nums[mid+1]>nums[mid]){
                low=mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return 56736372;
    }
} 

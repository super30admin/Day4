/*
Time -O(logn)
Space - O(1)
*/

class Solution {
    public int findMin(int[] nums) {
        
        int high = nums.length-1;
        int low =0;
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(nums[high]<nums[mid]) low= mid+1;
            else if(nums[low]>nums[mid]) {
                high = mid;
                low= low+1;}
            else if(nums[low] <=nums[high]) return nums[low];
            
            
        }
        return -1;
}}


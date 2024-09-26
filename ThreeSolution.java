// Time complexity: O(logn)
// Space complexity: O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return 0;
        }
        
        return findPeak(nums, 0, nums.length-1); 
    }
    
    public int findPeak(int[] nums, int start, int end){
        if(start == end){
            return start;
        }
        
        int mid = start + (end-start)/2;
        
        if(nums[mid] > nums[mid+1]){
            return findPeak(nums, start, mid);
        }
        return findPeak(nums, mid+1, end);
    }
}

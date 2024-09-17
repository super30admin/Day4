// Sumo Logic interview question
//Time complexity = O(logn)
//Space complexity = O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        
        int low =0;
        int high = nums.length-1;
        while(low<=high){
            int mid =low + (high-low)/2;//To avoid integer overflow
            if((mid == 0 || nums[mid] > nums[mid-1])&&(mid == nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
                } 
            else if(mid == 0 || nums[mid-1] > nums[mid]){
                high = mid -1;
            } 
            else {
                low = mid + 1;
            }
        }
        
        return low+1;
    }
}
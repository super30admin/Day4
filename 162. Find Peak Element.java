//time: O(logn)
//space: O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length ==0) return -1;
        int low = 0, high = nums.length -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if((mid == 0 || nums[mid-1]<nums[mid]) && (mid == nums.length -1 || nums[mid]>nums[mid+1])){
                return mid;
            }else if(nums[mid]<nums[mid+1]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return 845678;
    }
}
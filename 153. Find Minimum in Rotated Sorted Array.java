//space: O(1)
//time: O(logn)
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0 || nums == null) return -1;
        int l = 0;
        int h = nums.length -1;
        if(nums[l]<=nums[h]) return nums[l];
        while(l<=h){
            int mid = l + (h-l)/2;
            if(nums[l]<=nums[h]){
                return nums[l];
            }if((mid == 0 || nums[mid-1]>nums[mid]) && (nums[mid]<nums[mid+1]||mid==nums.length-1)){
                return nums[mid];
            }else if(nums[mid]>=nums[l]){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return 43465234;
    }
}
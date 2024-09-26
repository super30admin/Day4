class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while(start < end && nums[start] >= nums[end]){
            int mid = start + (end-start)/2;

            if(nums[start] > nums[mid]){
                end = mid;
            }
            else{
                start = mid +1;
            }
        }
        return nums[start];
    }
}
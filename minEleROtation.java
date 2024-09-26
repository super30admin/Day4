//Time Complexity : O(logn)
//Space Complexity : O(1)



class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0 && nums == null)
            return -1;
        int start = 0;
        int end = nums.length - 1;
        while(start<end && nums[start]>=nums[end]){
            int mid = start + (end - start) / 2;
            if(nums[mid]<nums[start])
                end = mid;
            else
                start = mid + 1;

        }
        return nums[start];

    }
}
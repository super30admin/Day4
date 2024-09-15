class Solution {
    public int findMin(int[] nums) {
    int min=6000;
    for(int i=0,j=nums.length-1;i<nums.length&&j>=0;i++,j--) {
        if(nums[i]>nums[j] || nums[j]<min)
            min=nums[j];
        else break;
        }
    return min;
    }
}

class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[s];
        }
        while (s<=e){
            int m = s + (e-s)/2;
            if (nums.length>2 && nums[m-1]>nums[m]){
                return nums[m];
            }
            if (nums[s]<=nums[m]){
                if(nums[m]<=nums[e]){
                return nums[s];
            }}
            if (nums[s]>nums[e] && nums[m]>=nums[s]){
                s=m+1;
            }
            else if (nums[s]>nums[e] && nums[m]<nums[s]){
                e=m;
            }
                else {return -1;}
        }
        return -1;
    }
}

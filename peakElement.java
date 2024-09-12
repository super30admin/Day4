class Solution {
    //Time complexity: O(logn)
    //Space complexity:O(1)
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        } 
        int l=0,r=nums.length-1;
        if(nums[0]>nums[1]){
            return 0;
        }
        while(l<=r){
            int m=l+(r-l)/2;
            if(m==nums.length-1){
                if(nums[m]>nums[m-1]){
                    return m;
                }
            }
            if(nums[m]>nums[m+1] && nums[m]>nums[m-1]){
                return m;
            }
            else if(nums[m]<nums[m+1]){
                l=m+1;
            }
            else{
                r=m-1;
            }
        }
        return -1;
    }
}
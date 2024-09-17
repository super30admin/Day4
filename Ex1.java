class Solution {
    public int[] searchRange(int[] nums, int target) {
             int l=0;
    int r=nums.length-1;
    while(l<r){
        int m=l+(r-l)/2;
        if(nums[m]<target){
            l=m+1;
        }else{
            r=m;
        }
    }
    int first=l;
    if(l<nums.length&&nums[l]==target){//l is in boundary and is the target
        l=0;
        r=nums.length-1;
        while(l<r){
            int m=l+(r-l+1)/2;
            if(nums[m]>target){
                r=m-1;
            }else{
                l=m;
            }
        }
        return new int[]{first, r};
    }
    return new int[]{-1,-1};
    }
}
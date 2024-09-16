//Time complexity: O(logn)
// Space complexity: O(logn)
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==0) return -1;
        if(nums.length==1) return 0;
        if(nums.length==2){
            if(nums[0]>nums[1]) return 0;
            else return 1;
        }
        int l=0;
        int h=nums.length-1;
        int m=l+(h-l)/2;
        while(l<=h){
          m=l+(h-l)/2;
        if(m==0 || (nums[m-1]<nums[m]) && (m==nums.length-1 || (nums[m+1]<nums[m]))) return m;
        if(nums[m+1]>nums[m]) l=m+1;
        else {
            h=m;
        }
        }
        return m;
    }
}

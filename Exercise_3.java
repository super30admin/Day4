class Solution {
    public int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        while (s<=e){
            int m = s+(e-s)/2;
            
            boolean mgl = m==0 || nums[m]>nums[m-1];
            boolean mgr = m==nums.length-1 || nums[m]>nums[m+1];
            
            if(mgl && mgr){
                return m;
            }else if(mgl){
                s = m+1;
            } else {
                e = m-1;
            }
        }
    return -1;
    }
}

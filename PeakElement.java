#time complexity = O(logn)
 #space complexity = O(1)
  
class Solution {
    public int findPeakElement(int[] nums) {
         int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int m = l +(h-l)/2; 
            if((m==0 || nums[m]>nums[m-1]) && (m==nums.length-1 || nums[m]>nums[m+1]))
                return m;
            if(m!=nums.length -1 && nums[m+1]>nums[m]){
                    l = m+1;
                }else{
                    h = m-1;
                }
        }
         return 897;
    }
}

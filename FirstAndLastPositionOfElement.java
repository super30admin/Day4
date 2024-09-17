//time complexity : O(logn)
//space complexity : O(1)
class Solution {
    //finding lower index
    public int lowerIndex(int[] nums,int target){
        int l=0;
        int h=nums.length-1;
        while (l<=h){
            int m=l+(h-l)/2;
            if (nums[m]==target){
                if (m==0 || nums[m-1]<nums[m]) {
                    return m;      
                }
                else{
                    h=m-1;
                }
            }
            else if (nums[m]>target){
                h=m-1;
            }
            else {
                l=m+1;
            }
        }
        return -1;
        
    } 
    //finding Higher index
      public int higherIndex(int[] nums,int target){
        int l=0;
        int h=nums.length-1;
       
        while (l<=h){
            int m=l+(h-l)/2;
            if (nums[m]==target){
                if (m==nums.length-1 || nums[m+1]>nums[m]) {
                    return m;      
                }
                else{
                    l=m+1;
                }
            }
            else if (nums[m]>target){
                h=m-1;
            }
            else {
                l=m+1;
               
            }
        }
        return -1;
        
    }
    public int[] searchRange(int[] nums, int target) {
    int lowerIndex=lowerIndex(nums,target);
    int higherIndex=higherIndex(nums,target);
        return new int []{lowerIndex,higherIndex};
    }
}
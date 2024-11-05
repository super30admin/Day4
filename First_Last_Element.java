class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        int[] l = new int[2];
        l[0]=l[1]=-1;
        while(j>=i){
            if(nums[i]==target){
                l[0]=i;
            if(nums[j]==target){
                l[1]=j;
                return l;
            }
            else 
                j--;
            }else 
                i++;
          
        } return l;
    }
}
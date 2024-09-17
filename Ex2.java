class Solution {
    public int findMin(int[] nums) {
           if(nums==null || nums.length==0)
        return -1;
 
    int i=0; 
    int j=nums.length-1;
 
    while(i<=j){
        if(nums[i]<=nums[j])
            return nums[i];
 
        int m=(i+j)/2;
 
        if(nums[m]>=nums[i]){
            i=m+1;
        }else{
            j=m;
        }
    }
    return -1;        
    }
}
class Solution {
    //Time complexity: O(logn)
    //Space complexity: O(1)
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int l=0,h=nums.length-1;
        if(nums[0]<nums[h]){
            return nums[0];
        }
        while(l<=h){
            int m=l+(h-l)/2;
            if(nums[m]>nums[m+1]){
                return nums[m+1];
            }
            if(nums[m]<nums[m-1]){
                return nums[m];
            }        
            if(nums[m]>nums[0]){
                l=m+1;
            }
            else {    
                h=m-1;
            }      
        }
        return -1;
    }
}
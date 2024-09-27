// Time Complexity :log(n)
// Space Complexity :log(n)
// Did this code successfully run on Leetcode:Yes 
// Any problem you faced while coding this :No

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums==null ||nums.length==0){
            return -1;
        }
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid==0||nums[mid-1]<nums[mid])&&(mid==nums.length-1||nums[mid+1]<nums[mid])){
                return mid;
            }
             if(mid>0 && nums[mid-1]>nums[mid+1]){
                high=mid-1;
            }
            else{
               low=mid+1; 
            }
        }
        return -1;
    }
}

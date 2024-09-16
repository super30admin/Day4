class Solution {
    public int findPeakElement(int[] nums) {
       int low=0;
       int high=nums.length-1;
       while(low<high){
           int mid=low+(high-low)/2;//finding mid
           boolean midGtthanleft = mid==0 || nums[mid] > nums[mid-1];//boolean variable to know if mid is greater than mid-1
           boolean midGtthanRight= mid==nums.length-1 || nums[mid] > nums[mid+1];// boolean variable to know if mid is greater than mid+1
           if(midGtthanleft && midGtthanRight)//if mid is greater than both left and right then it is peak element
               return mid;
           else if(midGtthanRight)//if mid is greater than right but not left then peak element will be on left side
               high=mid-1;
           else
               low=mid+1;//if mid is greater than left but not right then peak element will be on right side
       } 
        return low;
    }
}

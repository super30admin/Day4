class Solution {
    private int getstartingindex(int[] nums, int target){
        int s=0;
        int n=nums.length;    
       int e=n-1;
       while(s<=e){
           int mid=s+(e-s)/2;
           if(nums[mid]==target){
               if(mid==0 || nums[mid-1]!=target){
                   return mid;
               }
               else{
                   e=mid-1;
               }
           }
               else if(target<nums[mid]){
                   e=mid-1;
               }
           else{
                   s=mid+1;
               }
           }
        return -1;
        
    }
    private  int getLastindex(int[] nums, int target,int s){
    if(s==-1){
        return -1;
    }
        int n=nums.length;
       int e=n-1;
       while(s<=e){
           int mid=s+(e-s)/2;
           if(nums[mid]==target){
               if(mid==nums.length-1 || nums[mid+1]!=target){
                   return mid;
               }
               else{
                   s=mid+1;
               }
           }
               else if(target<nums[mid]){
                   e=mid-1;
               }
           else{
                   s=mid+1;
               }
           }
        return -1;
        
    }
    public int[] searchRange(int[] nums, int target) {
       
        int start=getstartingindex(nums,target);
        int last=getLastindex(nums,target,start);
        int[] r= new int[]{start,last};
       return r;
       }
    }

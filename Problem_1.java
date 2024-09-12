//binary search
//Time Complexity: O(logn)
//Space Complexity:O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length<1) return new int[]{-1,-1};
        int first= findfirst(nums, target);
        int last = findlast(nums,target);
        return new int[]{first,last};
    }
    private int findfirst(int[] nums,int target){
        int left=0,right=nums.length-1;
        int res=-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }else{
                res=mid;
                right=mid-1;
            } 
        }
        return res;
    }
    
    private int findlast(int[] nums,int target){
        int left=0,right=nums.length-1;
        int res=-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                res=mid;
                left=mid+1;
            } 
        }
        return res;
    }
}
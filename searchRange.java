class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=findFirstIndex(nums,target);
        int last=findLastIndex(nums,target,first);
        
        return new int[]{first,last};
    }
    public int findFirstIndex(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
             if(nums[mid]==target){
                if(mid==0 || (nums[mid]!=nums[mid-1]))
                    return mid;
                 else
                     high=mid-1;
            }else if(target<nums[mid]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
     public int findLastIndex(int[] nums,int target,int start){
         if(start==-1)
             return -1;
        int low=start;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || (nums[mid]!=nums[mid+1]))
                    return mid;
                else
                    low=mid+1;
            }
            else if(target<nums[mid]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
}

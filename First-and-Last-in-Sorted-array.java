class Solution{
    private  int firstAppearance(int []nums,int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int  mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid]>nums[mid-1]){
                    return mid;
                }else{
                    high=mid-1;
                }
            }else  if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }

    private int lastAppearrance(int []nums, int target){
        int low=0;
        int  high=nums.length-1;
        while(low<=high){
            int  mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 ||  nums[mid]<nums[mid+1]){
                    return mid;
                }else{
                    low=mid+1;
                }
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
    public int searchRange[](int []nums, int target){
        if(nums.length==0 || nums==null){
            return new []int {-1,-1};
        }
        int first=firstAppearance(nums, target);
        int last=lastAppearrance(nums, target);
        return new int[]{first,last};
    }
}
class Solution {
    private int binarySearch(int[] nums,int target,int low,int high,boolean isLeft){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isLeft){
                if(nums[mid]==target){
                    if(mid==0||nums[mid]>nums[mid-1]){
                        return mid;
                    }else{  //moving towards left
                        high = mid-1;
                    }
                }else if(nums[mid]>target){
                   high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(nums[mid]==target){
                    if(mid==0||nums[mid]<=nums[mid+1]){
                        return mid;
                    }else{//moving towards right
                        low = mid+1;
                    }
                }else if(nums[mid]<target){
                    low = mid+1;
                }else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums,int target){
        if(nums == null||nums.length==0) return new int[]{-1,-1};
        if(target<nums[0]||target>nums[nums.length-1]) return new int[]{-1,-1};
        int left = binarySearch(nums,target,0,nums.length-1,true);
        int right = binarySearch(nums,target,left,nums.length-1,false);
        return new int[]{left,right};
    }
}

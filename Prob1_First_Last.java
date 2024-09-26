class Solution {
    public int idx;
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return new int[] {-1,-1};
        if(target<nums[0] || target>nums[nums.length-1])
            return new int[] {-1,-1};
        int left=binarySearchLeft(nums,target);
        if(left==-1)
            return new int[]{-1,-1};
        idx=left;
        int right=binarySearchRight(nums,target);
        return new int[]{left,right};
    }
    private int binarySearchLeft(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        while(high>=low){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]!=target){
                    return mid;
                }
                else{
                    high=mid-1;
                }
            }
            else{
                if(target>nums[mid]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
    
     private int binarySearchRight(int[] nums,int target){
        int low=idx;
        int high=nums.length-1;
        while(high>=low){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]!=target)
                    return mid;
                else{
                    low=mid+1;
                }
            }
            else{
                if(target>nums[mid]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
         return idx;
    }
}


class Solution {
    public static  int[] searchRange(int[] nums, int target) {
        if(nums.length==0) {
            return new int[] {-1,-1};
        }
        int start=-1,end=-1;
        int high=nums.length-1;
        int low=0;
        while(high>=low) {
            int mid=low+(high-low)/2;
            if(nums[mid]==target) {
                if(mid-1<0) {
                start=mid;	
                }
                else {
                    if(nums[mid-1]!=target)
                        start=mid;
                    else{
                        start=binarySearch(nums,low,mid-1,target,true,false);
                    }
                }
                if(mid+1>=nums.length) {
                    end=mid;
                }
                else {
                    if(nums[mid+1]!=target)
                        end=mid;
                    else{
                        end=binarySearch(nums,mid+1,high,target,false,true);
                    }
                }
                return new int[] {start,end};
            }
            if(nums[mid]>target)
                high=mid-1;	
            else
                low=mid+1;
        }
        return new int[] {start,end};
    }
    private static int binarySearch(int[] nums,int start,int end,int target,boolean startChk,boolean endChk) {
        int high=end;
        int low=start;
        while(high>=low) {
            int mid=low+(high-low)/2;
            if(nums[mid]==target) {
                if(startChk) {
                    if(mid-1<0) {
                        return mid;
                    }
                    else {
                        if(nums[mid-1]!=target)
                            return mid;
                        else{
                            return binarySearch(nums,low,mid-1,target,true,false);
                        }
                    }

                }
                if(endChk){
                    if(mid+1>=nums.length) {
                        return mid;
                    }
                    else {
                        if(nums[mid+1]!=target)
                            return mid;
                        else{
                            return binarySearch(nums,mid+1,high,target,false,true);
                        }	
                    }
                }
            }
            if(nums[mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}
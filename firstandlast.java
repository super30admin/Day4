//Time Complexity : O(LogN)
//Space Complexity : O(1)


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        // if(nums.length == 0)
        //     return new int[]{-1,-1};
        int[] result = new int[2];
        result[0] = findFirst(nums,target);
        if(result[0] == -1){
            return new int[]{-1,-1};
        }
        result[1] = findSecond(nums,target,result[0]);
        return result;


    }
    public int findFirst(int[] nums,int target){
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = (start + end)/2;
            if(nums[mid]<target){
                start = mid + 1;
            }else if(nums[mid]>target)
                end = mid - 1;
            else
                end = mid;
        }
        return nums[start] == target ? start : -1;
    }
    public int findSecond(int[] nums,int target,int start){
        int end = nums.length-1;
        while(start<end){
            int mid = (start + end)/2 + 1;
            if(nums[mid]<target){
                start = mid + 1;
            }else if(nums[mid]>target)
                end = mid - 1;
            else
                start = mid;
        }
        return nums[end] == target ? end : -1;
    }
}
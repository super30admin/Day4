class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null || nums.length ==0){
            return new int[]{-1,-1};
        }
        if(target < nums[0] && target > nums[nums.length - 1]){
            return new int[]{-1,-1};
        }
        int start = binarySearch(nums,target,true);
        if(start == -1){
            return new int[]{-1,-1};
        }
        int end = binarySearch(nums,target,false);
        return new int[]{start,end};
    }
    
    public int binarySearch(int[]nums,int target, boolean left){
        int low = 0, mid = 0, high = (nums.length - 1);
        while(low <= high){
            mid = low + (high-low)/2;
            if(target == nums[mid]){
                if(left){
                    if((mid == 0) || (nums[mid] > nums[mid-1])){
                        return mid;
                    }else{
                        high = mid -1;
                    }
                }else{
                    if((mid == nums.length -1) || (nums[mid] < nums[mid+1])){
                        return mid;
                    }else{
                        low = mid + 1;
                    }
                }
            }else if(nums[mid] > target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}

//Time Complexity - BigO(log(n))
//Space Complexity - BigO(1)
//time: O(logn)
//space: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return new int[] {-1,-1};
        int left  = searchLeft(nums, target);
        int right = searchRight(nums, target);
        return new int[] {left, right};
    }
        private int searchLeft(int[] nums, int target){
            int l = 0;
            int h = nums.length -1;
            while(l<=h){
                int mid = l + (h-l)/2;
                if(nums[mid] == target){
                    if(mid==0 || nums[mid-1]<nums[mid]){
                        return mid;
                    }else{
                        h = mid-1;
                    }
                    }else if(target<nums[mid]){
                    h = mid-1;
                }else{
                    l = mid +1;
                }
                }
            return -1;
            }
        private int searchRight(int[] nums, int target){
            int l = 0;
            int h = nums.length -1;
            while(l<=h){
                int mid = l + (h-l)/2;
                if(nums[mid] == target){
                    if(mid == nums.length-1 || nums[mid]<nums[mid+1]){
                        return mid;
                    }else{
                        l = mid+1;
                    }
                }else if(target> nums[mid]){
                    l = mid+1;
                }else{
                    h = mid-1;
                }
            }
            return -1;
        }
}
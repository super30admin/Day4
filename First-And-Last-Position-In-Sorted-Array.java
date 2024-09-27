//time-O(log n)
//space-O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        if(target < nums[0] || target > nums[nums.length-1]) return new int[]{-1,-1};
        int first = binarySearchFirst(nums, target, 0, nums.length-1);
        int last = binarySearchLast(nums, target, first, nums.length-1);
        return new int[]{first, last};
    }
    public int binarySearchFirst(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1] < nums[mid]) return mid;
                else high = mid-1;
            }
            else if(nums[mid] < target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
    public int binarySearchLast(int[] nums, int target, int low, int high){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid] < nums[mid+1]) return mid;
                else low = mid+1;
            }
            else if(nums[mid] < target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}
//The approach here is to find the first occurence only first using Binary Search and then use that as the starting point for the Binary Search to find the last occurence.

class Solution {
    private int firstOccurence(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] != nums[mid-1]){
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
            else if(nums[low]<=target && nums[mid]>target){
                high = mid -1;
            }
            else {
                low = mid +1;
            }
        }
        return -1;
    }

    private int lastOccurence(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid] != nums[mid+1]){
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
            else if(nums[low]<=target && nums[mid]>target){
                high = mid -1;
            }
            else {
                low = mid +1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        if(nums.length == 0) return new int[] {-1,-1};
        int first = firstOccurence(nums, low, high, target);
        if(first == -1) return new int[] {-1,-1};
        int last = lastOccurence(nums, first, high, target);
        return new int[] {first, last};


        
    }
}
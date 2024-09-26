//TC = O(log n) where n is number of elements in array.
//SC = O(1)

class Solution {
    private int binarySearchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + ( high - low) / 2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                }
                else{
                    high = mid - 1;
                }                
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
    private int binarySearchLast(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + ( high - low) / 2;
            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid] < nums[mid+1]){
                    return mid;
                }
                else{
                    low = mid + 1;
                }                
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1, -1};
        if(nums[0] > target || nums[nums.length - 1] < target) return new int [] {-1, -1};
        int first = binarySearchFirst(nums, target);
        int last = binarySearchLast(nums, target);
        return new int[] {first, last};
    }
}

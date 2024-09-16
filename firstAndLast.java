//time complexity is O(log n)
//space complexity is O(1)

class Solution {
    private int binaryFirst(int[] nums, int target){
        int low = 0; int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                } else {
                    high = mid - 1;
                }
            }else if(target <= nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }

        private int binaryLast(int[] nums, int target){
        int low = 0; int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid + 1] > nums[mid]){
                    return mid;
                } else {
                    low = mid + 1;
                }
            }else if(target <= nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }


    public int[] searchRange(int[] nums, int target) {
        int first = binaryFirst(nums, target);
        int last = binaryLast(nums, target);
    return new int[] {first, last};
    }
}

class Solution {

    private int searchFirstValue(int start, int end, int[] nums, int target) {

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                if(mid ==0 || nums[mid - 1] < target) {
                     return mid;
                } else {
                   end = mid -1;
                }
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private int searchSecondValue(int start, int end, int[] nums, int target) {

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                if(mid == end || nums[mid + 1] > target) {
                   return mid;
                } else {
                     start = mid + 1;
                }
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        int firstValue = searchFirstValue(start, end, nums, target);

        if(firstValue < 0) return new int[]{-1, -1};

        int secondValue = searchSecondValue(firstValue, end, nums, target);
        return new int[]{firstValue, secondValue};
        
    }
}

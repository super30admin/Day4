class Solution {
    // Time complexity is O(logn)
    // Space complexity is O(n)
    // This solution is submitted on leetcode with no errors
    
    int firstIndex;
    public int[] searchRange(int[] nums, int target) {
        //edge case
        int n = nums.length-1;
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        if (nums[0] > target || nums[n] < target) return new int[] {-1,-1};
        firstIndex = leftBinarySearch(nums, target);
        if (firstIndex == -1) return new int[]{-1,-1};
        int secondIndex = rightBinarySearch(nums, target);
        return new int[]{firstIndex,secondIndex};
    }
    
    // writing function for left index
    private int leftBinarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if (nums[mid]==target){
                // checking left index
                if(mid == 0 || nums[mid]!=nums[mid-1]){
                    return mid;
                } else {
                    high = mid-1;
                }
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
    // writing function for right index
    private int rightBinarySearch(int[] nums, int target){
        int low = firstIndex;
        int high = nums.length -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if (nums[mid]==target){
                // checking right index
                if(mid == nums.length -1 || nums[mid]!=nums[mid+1]){
                    return mid;
                } else {
                    low = mid+1;
                }
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
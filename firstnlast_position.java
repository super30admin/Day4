//o(logn) time complexity
//o(1) space
//passed all test cases
// used bst and tried to find first and last positions to return as an array

class Solution {
    private int binarySearchFirst(int[] nums,int target){
        int first = -1;
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(nums[mid]>=target){
                end = mid - 1;
            }
            else {
                start = mid+1;
            }
            if(nums[mid]==target){
                first = mid;
            }
        }

        return first;
    }
    private int binarySearchLast(int[] nums,int target){
        int last = -1;
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start +(end-start)/2;

            if(nums[mid]<=target){
                start = mid+1;
            }else {

                end = mid - 1;

            }
            if(nums[mid]==target){
                last = mid;
            }
        }

        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0||nums == null) return new int[]{-1,-1};
        int first = binarySearchFirst(nums, target);
        int last = binarySearchLast(nums, target);
        return new int[]{first, last};

    }
}
// Time Complexity - O(LogN)
// Space Complexity - O(1)
// This Solution worked on LeetCode

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};
        int left = BinarySearchLeft(nums,target);
        int right = BinarySearchRight(nums,target);
        return new int[]{left,right};
    }
    
    private int BinarySearchRight(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid] < nums[mid+1])
                    return mid;
                else
                    low = mid+1;
            }
            else if(nums[mid] > target){
                high = mid-1;   
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
    
    private int BinarySearchLeft(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid - 1])
                    return mid;
                else
                     high = mid-1;
            }
            else if(nums[mid] > target){
                high = mid-1;   
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}

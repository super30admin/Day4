
// Time Complexity : O(log n) + O(log n) -> 1(log n) -> O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english: Use Two binary search to find the first and last index, in first binary search find the first index of the target, use the output from the first binary search as the first input index to perform the second binary search to return the last index

// Your code here along with comments explaining your approach

class Solution {
    
    private int binarySearchLast(int [] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid == nums.length -1 || nums[mid] < nums[mid+1]){
                    return mid;
                }else{
                    // keep moving right
                    low = mid+1;
                }
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    
    private int binarySearchFirst(int [] nums, int target){
        int low = 0;
        int high = nums.length -1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    // keep moving left
                    high = mid - 1;
                }
            }else if (nums[mid]<target){
                low = mid +1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1,-1};
        
        int n = nums.length;
        
        if(nums[0]>target || nums[n-1]< target) return new int[] {-1,-1};
        
        int first = binarySearchFirst(nums, target);
        
        if(first == -1) return new int[] {-1,-1};
        
        int last = binarySearchLast(nums, first, n-1, target);
        
        return new int[] {first, last};
    }
}
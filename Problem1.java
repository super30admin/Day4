// Time Complexity: Log(N)
// Space Complexity: O(1)
// I was able to run this code successfully on leetcode. However, I was unable to submit it because I was getting a Time Limit Exceded error; 
//In this approach, we use binary search twice; first to find the starting index and then the second time to find the
//last index of the given number.


class Solution {
   
    private int binarySearchFirst(int []nums, int target){
        int low = 0; int high = nums.length -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid ==0 || nums[mid -1]!=nums[mid]){
                    return mid;
                }else{
                    high= mid -1;
                }
            } else if(nums[mid]>target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    
    private int binarySearchLast(int []nums, int target){
        int low = 0; int high = nums.length -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid +1]!=nums[mid]){
                    return mid;
                }else{
                    low= mid -1;
                }
            } else if(nums[mid]>target){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};   
        if(nums[0]>target || nums[nums.length - 1]<target)return new int[]{-1,-1};
        int first = binarySearchFirst(nums,target);
        if(first == -1) return new int[]{-1,-1};
        int last = binarySearchLast(nums,target);
        return new int[]{first,last};
    }
}
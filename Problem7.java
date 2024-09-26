//Time Complexity : O(log n) + O(log n) ~ O(log n)

/*
Approach:
    Perform BinarySearch twice to find the each index of the target
    Calculate the middle & perfor the Binary Search.
    When you find the target element, check the neighbours so that the index of first occurence & last occurence of the target is returned
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int a = findFirstPeak(nums, 0, nums.length-1, target);
        int b = findSecondPeak(nums, 0, nums.length-1, target);
        return new int[]{a,b};
    }

    
    // Method to find the first occurence of the number
    public int findFirstPeak(int[] nums, int start, int end, int target){
        while(start<=end){
            int mid = start + (end - start)/2;            
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]<target) return mid;
                else end = mid -1;
            } else if(nums[mid]>target) end = mid -1;
            else start = mid + 1;
        }
        return -1;
    }
    
    // Method to find the second occurence of the number
    public int findSecondPeak(int[] nums, int start, int end, int target){
        while(start<=end){
            int mid = start + (end - start)/2;            
            if(nums[mid]==target){
                if(mid==(nums.length-1) || nums[mid+1]>target) return mid;
                else start = mid+1;
            } else if(nums[mid]>target) end = mid -1;
            else start = mid + 1;
        }
        
        return -1;
    }
}
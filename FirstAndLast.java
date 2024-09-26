// Time Complexity : O(logN), N elements of array
// Space Complexity : O(1) no additional space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : n/a

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int startIndex = search(nums,target,true); // goal is to find index of first occurrence
        if (startIndex == -1) return new int[]{-1,-1}; // if can't find first occurence, 
        
        int lastIndex = search(nums,target,false); // goal is to find index of last occurrence
        
        return new int[]{startIndex,lastIndex};
    }
    
    private int search(int[] nums, int target, boolean findFirst){
        int left = 0;
        int right = nums.length - 1;

        int mid;
        while (left <= right){
            mid = (left + right) / 2;
            if (target == nums[mid]){ // starting element found
                if (findFirst){ // goal is to find start index
                    if (mid == left || target != nums[mid - 1]){ // starting index found
                        return mid;
                    }
                    // if not found
                    right = mid - 1; // search left side for start index
                }
                else{ // goal is to find last index
                    if (mid == right || target != nums[mid + 1]){ // last index found
                        return mid;
                    }
                    // if not found
                    left = mid + 1; // search right side for end index
                }
            }
            else if (target > nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
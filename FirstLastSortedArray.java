class Solution {
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // Did this code successfully run on Leetcode : Yes
    // thought process: we're doing two binary searches, one for the first occurence and one for the last occurence
    // for the first occurence, we're checking if the target is at the mid, if it is, we're checking if it's the first occurence
    // if it's not the first occurence, we're doing a binary search in the left part
    // for the last occurence, we're checking if the target is at the mid, if it is, we're checking if it's the last occurence
    // if it's not the last occurence, we're doing a binary search in the right part
    
    public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length ==0){
        return new int[]{-1,-1};
    }
    if (target < nums[0] || target > nums[nums.length-1]){
        return new int[]{-1,-1};
    }
    int low = 0;
    int high = nums.length-1;

    int first = binarySearchFirst(nums, target);
      if (first == -1){
        return new int[] {-1,-1};
    }
    int second = binarySearchSecond(nums, target);
    return new int[]{first, second};


    }
  private int binarySearchFirst(int[] nums,int target){
    int low = 0;
    int high = nums.length -1;
    while (low <= high){
        int mid = low + (high - low)/2;
        if (nums[mid] == target){
            if (mid == 0 || nums[mid-1] != nums[mid]){
                return mid;
            }
            high = mid -1; 
        }
        else if (nums[mid] < target){
            low = mid +1;
        } else {
            high = mid -1;
        }
    }
    return -1;
}

  private int binarySearchSecond(int[] nums,int target){
    int low = 0;
    int high = nums.length -1;
    while (low <= high){
        int mid = low + (high - low)/2;
        if (nums[mid] == target){
            if (mid == nums.length-1 || nums[mid+1] != nums[mid]){
                return mid;
            }
            low = mid +1; 
        }
        else if (nums[mid] < target){
            low = mid +1;
        } else {
            high = mid -1;
        }
    }
    return -1;
}
}


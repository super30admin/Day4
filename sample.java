// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Find the first and the last position of the element in sorted array
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOcc = findFirst(nums, target);
        int lastOcc = findLast(nums, target);
        return firstOcc == -1? new int [] {-1,-1} : new int [] {firstOcc, lastOcc};
    }
    public int findFirst(int [] nums, int target) {

        int firstEle = -1;
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                // if found the element move towards the left to find if there is any element
                firstEle = mid;
                end = mid - 1;
            }
            else if(target > nums[mid]) {
                start = mid + 1;
            }
            else if(nums[mid] > target) {
                end = mid - 1;
            }
        }
        return firstEle;
    }
    public int findLast(int [] nums, int target) {
        int lastEle = -1;
        int start = 0, end = nums.length-1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                // if found element then move towards right to find if there is any element
                lastEle = mid;
                start = mid + 1;
            }
            else if(nums[mid] > target) {
                end = mid - 1;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        return lastEle;
    }
}

// Approach 2
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Find the first and the last position of the element in sorted array
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOcc = findFirst(nums, target);
        if(firstOcc == -1) {
            return new int[] {-1, -1};
        }
        int lastOcc = findLast(nums, target, firstOcc);
        return new int [] {firstOcc, lastOcc};
    }
    public int findFirst(int [] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
               // if we are at the first element or the element at mid is not equal to element at mid -1
               if(mid == 0 || nums[mid] != nums[mid-1]) {
                   return mid;
               }
               // element at mid is equal to element at mid - 1 then we do try and find on the left
               else if(mid > 0 && nums[mid] == nums[mid-1]){
                   end = mid - 1;
               }
            }
            else if(target > nums[mid]) {
                start = mid + 1;
            }
            else if(nums[mid] > target) {
                end = mid - 1;
            }
        }
        return -1;
    }
    public int findLast(int [] nums, int target, int low) {
        int start = low, end = nums.length-1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
               // if the element is the last element or the element at mid is not equal to element at mid + 1
               if(mid == nums.length -1 || nums[mid] != nums[mid + 1]) {
                   return mid;
               }
               else {
                   // if element at mid is equal to element at mid + 1 then we start searching from mid +1
                   if(mid < nums.length - 1 && nums[mid] == nums[mid + 1] ) {
                       start = mid + 1;
                   }
               }
            }
            else if(nums[mid] > target) {
                end = mid - 1;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        return -1;
    }
}

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Find the peak element
class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            // check if the peak element is greater than both of its neighbours
            if((mid == 0 || nums[mid] > nums[mid -1]) && (mid == nums.length -1 || nums[mid] > nums[mid+1])) {
                return mid;
            }
            // [1,2] fails if we don't check mid > 0
            else if(mid > 0 && nums[mid] < nums[mid-1]) {
                end = mid - 1;
            }
            else if(mid < nums.length && nums[mid] < nums[mid +1]) {
                start = mid + 1;
            }
        }
       return -1;
    }
}

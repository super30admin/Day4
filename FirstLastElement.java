/**Leetcode problem 34 - Find First and Last Position of Element in a sorted array */

public class FirstLastElement {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if(nums.length == 0 || nums == null){
                return new int[] {-1,-1};
            }
            if(target < nums[0] || target > nums[nums.length-1]){
                return new int[] {-1,-1};
            }
            int first = binarySearchFirst(nums,target);
            int second = binarySearchSecond(nums,target, first);
            return new int[] {first, second};
        }
        private int binarySearchFirst(int[] nums, int target){
            int low = 0; 
            int high = nums.length-1;
            while(low<=high){
                int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid ==0 || nums[mid -1]< nums[mid]){
                    return mid;
                }
                else if(nums[mid-1] == nums[mid]){
                    high = mid -1;
                }
            }
                else if(target>nums[mid]){
                    low = mid +1;
                }
                else {
                    high = mid -1;
                }
            }
            return -1;
        }
        private int binarySearchSecond(int[] nums, int target, int first){
            int low = first; 
            int high = nums.length-1;
            while(low<=high){
                int mid = low + (high - low)/2;
                if(nums[mid] == target){
                    if(mid ==nums.length -1 || nums[mid +1]> nums[mid]){
                    return mid;
                    }
                else if(nums[mid+1] == nums[mid]){
                    low = mid +1;
                    }
                }
                else if(target>nums[mid]){
                    low = mid +1;
                }
                else {
                    high = mid -1;
                }
            }
            return -1;
        }
    }
}

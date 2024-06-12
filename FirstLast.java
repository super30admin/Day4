public class FirstLast {
    
    class Solution {

        private int leftBinarySearch(int[] nums, int left, int right, int target) {
            while(left <= right) {
                int mid = left + (right-left)/2;
                if(nums[mid] == target) {
                    if(mid == 0 || nums[mid-1] < nums[mid]) { 
                        return mid;
                    } else {
                        right = mid -1;
                    }
                } else if(nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
   
        private int rightBinarySearch(int[] nums, int left, int right, int target) {
            while(left <= right) {
                int mid = left + (right-left)/2;
                if(nums[mid] == target) {
                    if(mid == nums.length-1 || nums[mid] < nums[mid+1]) {
                        return mid;
                    } else {
                        left = mid + 1;
                    }
                } else if(nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
   
        public int[] searchRange(int[] nums, int target) {
            if(nums == null || nums.length == 0 ) return new int []{-1,-x1};
            if(nums[0] > target || nums[nums.length-1] < target) return new int []{-1,-1};
            int first = leftBinarySearch(nums, 0, nums.length-1, target);
            if(first==-1) return new int []{-1,-1};
            int last = rightBinarySearch(nums, first, nums.length-1, target);
            return new int[] {first,last};
        }
    }

}

// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only:
/*Since the array is sorted we will use binary search to locate first and last position of element*/
class First_LastPositionOfAnElement{
    public static int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid; 
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }

    public static int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid; 
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        result[0] = findFirstPosition(nums, target);
        if (result[0] != -1) {
            result[1] = findLastPosition(nums, target);
        }
        
        return result;   
    }


}
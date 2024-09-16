// Time Complexity : O(log(n))
// Space Complexity : O(1) -> contant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class findAllElements {
    
    public int binarySearch(int[] nums, int start, int end, int target) {
        int mid;
        while(start <= end){
            mid = start + (end - start) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int leftFlag, rightFlag;
        int[] result = {-1, -1};
        int start = 0, end = nums.length - 1;
        leftFlag = rightFlag = binarySearch(nums, start, end, target);
        //Iterative Binary search on left portion
        while(leftFlag != -1) {
            result[0] = leftFlag;
            leftFlag = binarySearch(nums, start, leftFlag-1, target);
        }
        //Iterative Binary search on right portion
        while(rightFlag != -1) {
            result[1] = rightFlag;
            rightFlag = binarySearch(nums, rightFlag+1, end, target);
        }
        return result;
        
    }
}
//162. Find Peak Element - https://leetcode.com/problems/find-peak-element/description/
//Time Complexity: log(n)
//Space Complexity: O(1)

class Solution {
    public int findPeakElement(int[] nums) {

        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if((mid == low || nums[mid-1] < nums[mid]) &&
                    (mid == high || nums[mid+1] < nums[mid])){
                return mid;
            }
            //moving to the greater side
            else if(nums[mid] < nums[mid+1]){
                low = mid + 1;
            }
            //moving to the greater side
            else if(nums[mid] > nums[mid+1]){
                high = mid - 1;
            }
        }
        return -1;
    }
}
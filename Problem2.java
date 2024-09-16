// Time Complexity - O(logN)
// Space Complexity - O(1)
// This solution worked on LeetCode

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length ==0)
            return -1;
        int low = 0;
        int high = nums.length -1;
        while(low < high){
            int mid = low +(high-low)/2;
            if(nums[mid] > nums[high]){
                low = mid+1;    
            }
            else{
                high = mid;
            }
        }
        return nums[low];
    }
}

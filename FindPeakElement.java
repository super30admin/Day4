//time complexity : O(logn)
//space complexity : O(1)

class Solution {
    public int findMin(int[] nums) {
        int low =0;
        int high=nums.length-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];  
        }
        
}
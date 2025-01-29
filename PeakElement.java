//Using binary serach to eliminate half of the array.
// Time complexity - O(logn)
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high){
            int mid = (low + high) / 2;
            if(nums[mid+1] > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return high;
    }
}
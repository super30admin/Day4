//o(logn) time complexity
//o(1) space
//passed all leetocde case
//used bst on unsorted side to find minimum value

class Solution {
    public int findMin(int[] nums) {
        //if(nums == null || nums.length ==0 ) return -1;
        int low =0;
        int high = nums.length - 1;
        while(low<high){
            int mid = low + (high - low)/2;
            if(nums[mid]>nums[high]){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
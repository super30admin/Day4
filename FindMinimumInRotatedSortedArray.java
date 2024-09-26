//TC - O(log n) where n is number of elements in array.
//SC - O(1)

class Solution {
    public int findMin(int[] nums) {
       if(nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while(l <= r){
            if(nums[l] < nums[r]) return nums[l];
            int mid = l + (r - l) / 2;
            if((mid == 0 || nums[mid] < nums[mid - 1]) && 
               (mid == nums.length - 1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            else if(nums[l] <= nums[mid]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return -1;
    }
}

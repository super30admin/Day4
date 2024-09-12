// Time Complexity: O(log n)
// Space Complexity: O(1)
// Steps: do BS
// 1. fiind mid
// 2. check if element at mid is less than next & prev element 
// 3. do right search if element at high is less than mid element, else left search

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if((mid == nums.length - 1 || nums[mid] <= nums[mid + 1]) && 
               (mid == 0 || nums[mid] < nums[mid - 1])){
                return nums[mid];
            }
            if(nums[high] < nums[mid] ){
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return -1;
    }
}
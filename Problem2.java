//Time Complexity: Log(N) Since we are using binary search
//Space Complexity: O(1)
//For this solution, we use binary search to move to the unsorted side of the array as our minimum element will lie in that half of the array.


class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int low = 0, high = nums.length -1;
        while(low<=high){
            if(nums[low]<nums[high]) return nums[low];
           
            int mid = low + (high - low)/2;
            
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid]< nums[mid +1]) ){
                return nums[mid];
            }else if(nums[low]<= nums[mid]){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return 3232;
    }
}
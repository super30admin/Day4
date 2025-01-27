//The idea here is the the minimum number should be smaller that it's adjacent members. we also added few conditions if the minimum number is at the start or end of the array.
//Time complexity: O(log n)
//Space complexity: O(1)
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            if(nums[low]<=nums[high]){
            return nums[low];
        }
            int mid = low + (high-low)/2;
            if((mid == 0 || nums[mid]<nums[mid-1]) && (mid == nums.length-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            else if(nums[low]<=nums[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}

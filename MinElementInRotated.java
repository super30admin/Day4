// Time complexity - O(log n)
//space complexity - O(1)
//Since the array is sorted and rotated, we get the middle element. There will always be one sorted half and another unsorted half. 
//the min element is always in the unsorted half mostly. 
//we check the element to the left and right of the mid element and if the mid is smaller than both the elements, then it is the minimum element. 
// else, we check the unsorted part. 
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            if(nums[low] <= nums[high]){
                return nums[low];
            }
            int mid = low + (high - low) /2;
            if((mid == low || nums[mid - 1] > nums[mid]) && (mid == high || nums[mid +1] > nums[mid])){
                return nums[mid];
            }
            if(nums[low] <= nums[mid]){
                low = mid + 1;
                }
            else{
                    high = mid - 1;
                }
            
            


        }
    return 56483; 
    }
}

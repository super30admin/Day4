/**
 *
 * Algo:
 *  - Min will always exits in the unsorted array.
 *  - If the array is sorted then the first element is the min
 *
 * Time Complexity:o(log(n))
 * Space Complexity: O(1)
 *
 */
class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums ==null || nums.length==0){
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            if(nums[low]<=nums[high])
                return nums[low];
            int mid = low + (high-low)/2;
            if((mid ==0 ||nums[mid-1]>=nums[mid]) && (mid==high||nums[mid]<=nums[mid+1])){
                return nums[mid];
            }else if(nums[low]<=nums[mid]){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
}
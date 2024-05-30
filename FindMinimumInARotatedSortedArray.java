//time - O(log n)
//space - O(1)
public class FindMinimumInARotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        int low = 0, high = nums.length-1;
        while(low<=high){

            if(nums[low]<=nums[high]) return nums[low];

            int mid = low + ((high-low)/2);

            if((mid==0 || nums[mid] < nums[mid-1]) && (mid==nums.length-1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            } else if(nums[low]<=nums[mid]) {//Check if left side is sorted, minimum will always lie in the unsorted part
                low = mid+1;
            } else {//If right side is sorted, move the search space to left part which is unsorted
                high = mid-1;
            }
        }
        return -1;
    }
}

package S30_Codes.Binary_Search_2;

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Binary-Search-2

class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {

        int start = 0, end = nums.length-1;

        while(start <= end){

            // array is already sorted
            if(nums[start] <= nums[end])
                return nums[start];

            int mid = start + (end-start)/2;

            // mid is min
            if(mid != 0 && nums[mid] < nums[mid-1])
                return nums[mid];

            // left sorted
            if(nums[start] <= nums[mid])
                start = mid+1;
                // right sorted
            else
                end = mid-1;
        }
        return -1;
    }
}
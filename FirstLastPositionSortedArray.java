// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


class FirstLastPositionSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int start = 0;
        int end = nums.length - 1;
        int midIndex;

        while (start <= end) {
            midIndex = start + ((end - start) / 2);
            while(nums[midIndex] == target){
                int endTemp = midIndex;
                int pivot = midIndex;
                while(start <= endTemp){
                    pivot = start + ((endTemp - start) / 2);
                    if(nums[pivot] != target)
                        start = pivot + 1;
                    else
                        endTemp = pivot - 1;
                }
                if(nums[pivot] != target)
                    pivot++;
                result[0] = pivot;
                start = midIndex;
                while(start <= end){
                    pivot = start + ((end - start) / 2);
                    if(nums[pivot] != target)
                        end = pivot - 1;
                    else
                        start = pivot + 1;
                }
                if(nums[pivot] != target)
                    pivot--;
                result[1] = pivot;
                return result;
            }
            if (nums[midIndex] > target)
                end = midIndex - 1;
            else
                start = midIndex + 1;
      }
        return result;
    }
}
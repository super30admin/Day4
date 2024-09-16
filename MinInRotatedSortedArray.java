class MinInRotatedSortedArray{
    // Time Complexity : O(Log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


    // This problem is mixture of Binary Search with target in rotated sorted array and first bad version
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;

        /*
           1. My trick is to check if the specific target is being asked in the question.
           2. If there is no mention of the target to search, then it means we should consider mid element
              in one of the scope. This logic comes from first bad version problem. We dont know whether the
              mid element is minimum or not.
           3. As we are considering mid element as possible answer, which pointer should get mid pointer in case
              scope is decided. As the array is expected to be sorted, left pointer always gets lower value
              so, if lower pointer does not contain min value then it should be rules out.
           4. Thats why right pointer got the mid pointer.

         */
        while (left < right){
            int mid = left + (right - left)/2;

            if (nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return nums[left];
    }
}

/*
Leetcode analysis:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
Memory Usage: 38.6 MB, less than 39.57% of Java online submissions for Find Minimum in Rotated Sorted Array.
 */
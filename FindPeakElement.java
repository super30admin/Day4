class FindPeakElement{
    // Time Complexity : O(Log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


    //the thought process is explained in previous problem of MinInRotatedSorted Array.
    /*
    Whenever we are not asked to find a specific target, the binary search should breakdown into
    pointers considering the mid element and one without considering mid element.
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left < right){
            int mid = left + (right - left)/2;

            if (nums[mid] < nums[mid+1]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return left;
    }
}
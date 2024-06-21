// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/* perform binary search taking low = 0 and high = lengh of the array -2*/
class PealElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // Edge cases

        if(n == 1)
            return 0;

        if(nums[0] > nums[1] )
            return 0;

        if(nums[n-1] > nums[n-2])
            return n-1;

        int low = 0;
        int high = n-2;

        while(low <= high) {
            int mid = start + (end - start)/2;

            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1])
                return mid;
            else if(nums[mid] < nums[mid + 1])
                low = mid + 1;
            else if(nums[mid] < nums[mid - 1])
                high = mid - 1;
        }

        return -1;
    }

}
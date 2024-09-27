// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I do not clearly understand why at last peak element is at left pointer.
class Main {

    public static int findPeakElement(int[] nums) {

        // initialize left pointer and high pointer
        int l = 0;
        int r = nums.length - 1;

        // loop for traverse for binary search
        while (l < r) {
            // find the mid element
            int mid = l + (r - l) / 2;
            // if our element is less than left element and greater than right element then
            // we return mid index. But here it may possible that our element is first or
            // last that are peak element. So, we also have to consider it. So, we check our
            // mid index is first one or last one every time
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1]))
                return mid;

            // if mid element is greater than right element that means we discard right side
            // of the arrayF
            else if (nums[mid] > nums[mid + 1])
                r = mid;

            // else we discard left side of the array
            else
                l = mid + 1;
        }

        // if element is less than 3 left index would be our index of peak element
        return l;

    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 1, 3, 5, 6, 4 };
        System.out.println("index of peak element is: " + findPeakElement(nums));
    }
}
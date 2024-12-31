// Time Complexity: O(log n)
// Space Complexity: O(1)

class findMinRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 })); // 1
        System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 })); // 0
        System.out.println(findMin(new int[] { 11, 13, 15, 17 })); // 11
        System.out.println(findMin(new int[] { 4, 5, 1, 2, 3 })); // 1
    }
    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        //binary search condition
        while (low <= high) {
            //if array is sorted return low
            if (nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == n - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            //Min value lies in unsorted part so the below condition for checking sorted or unsorted
            if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 1111;
    }
}